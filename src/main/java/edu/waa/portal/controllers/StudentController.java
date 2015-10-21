package edu.waa.portal.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import edu.waa.portal.controllers.validator.UserNameCustomValidator;
import edu.waa.portal.model.Student;
import edu.waa.portal.model.StudentCourseEnrolled;
import edu.waa.portal.service.StudentService;

@Controller
@RequestMapping(value = "/student")
@SessionAttributes("USERID")
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	@Autowired
	UserNameCustomValidator userNameValidator;
	
/*	@RequestMapping(value = "", method = RequestMethod.GET)
	public String studentLogin()
	{
		System.out.println("inside student login ");
		return "Login";
	}*/
	
	@RequestMapping(value = "/enrollCourses", method = RequestMethod.GET)
	public String enrollDistanceEducationCourses(@ModelAttribute("student") Student student, Model model) 
	{
		System.out.println("ajax check");
		//model.addAttribute("studentID", 1001); //get this from session once login 
		List<String> courseIds = new ArrayList<String>();
		/*courseIds.add("402-BigData");
		courseIds.add("702-SystemAnalysis");*/
		
		courseIds = studentService.getAvailableCourses();
		for (String string : courseIds) {
			System.out.println("course Id "+ string);
		}
		model.addAttribute("courseIds", courseIds);
		
		return "enrollCourse";

	}

	@RequestMapping(value="/enrollCourses", method=RequestMethod.POST)
	public @ResponseBody String enrollCourses( @RequestBody String courseIdsandDesc, Model model)
	{
		
		System.out.println(model.asMap().get("USERID"));
		System.out.println("courseIdsandDesc" +courseIdsandDesc.trim());
		System.out.println(" inside enrollCourses "+ ((ModelMap) model).get("USERID"));
		
		Integer studentId = (Integer) (model.asMap().get("USERID"));
		String returnText = "";
		List<Integer> courseIds = new ArrayList<Integer>();
		List<String> courseDesc = new ArrayList<String>();
		
		String[] courseIdsPlusDesc = courseIdsandDesc.split("&");
		
		
		for (String fullObject : courseIdsPlusDesc) 
		{
			System.out.println("string "+fullObject);
			String[] courseAndBlock = fullObject.split("=");
			
				System.out.println("course "+courseAndBlock[1]);
				String[] temp = courseAndBlock[1].split("-");
				System.out.println("temp[0] "+temp[0]+" temp[1]" +temp[1]);
				courseIds.add(Integer.parseInt(temp[0]));
				courseDesc.add(temp[1]);
				
					
		}
		System.out.println("courseIds "+courseIds.size());
		System.out.println("courseDesc "+courseDesc.size());
		
		Set<Integer> duplicateList = findDuplicates(courseIds);
		
		if(duplicateList.size()>0)
			return returnText+"U are not allowed to select duplicate courses";
		
		studentService.enrollCourses(courseIds, courseDesc, studentId);
		
		return returnText+"Your Courses are successfully enrolled ";
		
		
	}
	
	
	
	@RequestMapping(value = "/editProfile", method = RequestMethod.GET)
	public String editStudentProfile(@ModelAttribute("student") Student student, Model model)
	{
		System.out.println("student id in session "+ model.asMap().get("USERID"));
		Integer studentId = (Integer) (model.asMap().get("USERID"));
		
		 student = studentService.getStudentProfile(studentId);
		 System.out.println("imageUploadedOrNot "+student.getImageUploadedOrNot());
		model.addAttribute("student", student);
		return "editStudentProfile";
	}
	
	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public @ResponseBody String updateStudentProfile( @RequestBody Student student) //please use this attribute else some format conersion will come
	{
		System.out.println("student data "+student.getFullName() +"id "+student.getUserName());
		studentService.updateStudentProfile(student); //handle the exception
		
			
		 
		return "Profile updated successfully";
		
		
	}
	
	@RequestMapping(value = "/upoadProfilePicture", method = RequestMethod.POST)
	public String uploadProfilePicture(@ModelAttribute("student") Student student, Model model, HttpServletRequest request )
	{
		
		boolean flag = false;
		System.out.println("inside upload " +student.getStudentId());
		 MultipartFile image = student.getProductImage();
		 //MultipartFile localImage = student.getProductImage();
		 
		// String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		 String localRootDirectory = "C:\\Users\\vasanthbabu\\WAAWorkspace\\TitansRecord\\src\\main\\webapp";
		 System.out.println("localRootDirectory "+localRootDirectory);
		//isEmpty means file exists BUT NO Content
			if (image!=null && !image.isEmpty()) {
		       try {
		    	  // localImage.transferTo(new File(rootDirectory+"\\images\\"+student.getStudentId() + ".jpg"));
		    	   image.transferTo(new File(localRootDirectory+"\\images\\"+student.getStudentId() + ".jpg")); //here i am going for permanant storage
		    	   
		    	  flag = true;
		    	   System.out.println("inside try ");
		       } catch (Exception e) {
		    	   //create your exception 
				throw new RuntimeException("Product Image saving failed", e);
		   }
		   }
			
			if(flag = true)
			{
				System.out.println("Db update");
				studentService.updateImageUploadedOrNotField(student.getStudentId());
				
			}
				
			 model.addAttribute("student", student);
			return "redirect:/student/editProfile";
			  
			//return "studentDetails";
	}
	
	@RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
	public String viewStudentProfile(@ModelAttribute("student") Student student, Model model)
	{
		System.out.println("session student ID "+model.asMap().get("USERID"));
		int studentID = (int) model.asMap().get("USERID");
		
		 student = studentService.getStudentProfile(studentID);
		 System.out.println("imageUploadedOrNot "+student.getImageUploadedOrNot());
		model.addAttribute("student", student); //u need to set attribute else it will be problem
		return "viewStudentProfile";
	}
	
	@RequestMapping(value = "/viewEnrolledCourses", method = RequestMethod.GET)
	public String viewStudentEnrolledCourses(Model model) //model attribute not needed
	{
	
		System.out.println("inside enroll courses ");
		System.out.println("session student ID "+model.asMap().get("USERID"));
		int studentID = (int) model.asMap().get("USERID");
		
		List<StudentCourseEnrolled> listOfCoursesEnrolled = studentService.getStudentEnrolledCourses(studentID); //change this to session 
		
		for (StudentCourseEnrolled studentCourseEnrolled : listOfCoursesEnrolled) 
		{
			if(studentCourseEnrolled.getGrade() == "" || studentCourseEnrolled.getGrade() == null)
				studentCourseEnrolled.setGrade("Not Completed");
			
		}
		
		System.out.println("listOfCoursesEnrolled size"+listOfCoursesEnrolled.size());
		model.addAttribute("listOfCoursesEnrolled", listOfCoursesEnrolled);
		return "viewStudentEnrolledCourses";
	}
	

	public Set<Integer> findDuplicates(List<Integer> listContainingDuplicates) {
		final Set<Integer> setToReturn = new HashSet();
		final Set<Integer> set1 = new HashSet();

		for (Integer yourInt : listContainingDuplicates) {
			if (!set1.add(yourInt)) {
				setToReturn.add(yourInt);
			}
		}
		return setToReturn;
	}

}
