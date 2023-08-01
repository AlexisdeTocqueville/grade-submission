package com.ltp.gradesubmission;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class GradeController {

    List <Grade> studentGrades = new ArrayList<>();
    
    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade){
        int index = getGradeIndex(grade.getId());
        if (index == Constants.NOT_FOUND){
            studentGrades.add(grade);
        }
        else{
            studentGrades.set(index, grade);
        }
        return "redirect:/grades";

    }

    @GetMapping("/")
    public String getForm(Model model, @RequestParam(required = false) String id){
        int index = getGradeIndex(id);
        model.addAttribute("grade", index == Constants.NOT_FOUND ? new Grade() : studentGrades.get(index));
        return "form";
    }

    @GetMapping("/grades")
    public String getGrades(Model model) {
        // the name parameter is only needed when we need to update something

        /**
         * Alternatively, one can initialize the list in the getGrades method
         * 
         * List <Grade> studentGrades = new ArrayList <> ( );
         * studentGrades.add(new Grade("John Smith", "CHEM180", Score.C_PLUS));
         * studentGrades.add(new Grade("Alex Perelman", "COMP252", Score.A_PLUS));
         * studentGrades.add(new Grade("Nicholas Tarkovsky", "MATH254", Score.B));
         * studentGrades.add(new Grade("Morris Zhang", "PHSY251", Score.A));
         * 
         **/

        model.addAttribute("grades", studentGrades);
        return "grades";
    }
    

    public Integer getGradeIndex(String id){
        for (int i = 0; i < studentGrades.size(); i++){
            if (studentGrades.get(i).getId().equals(id)) {
                return i;
            }
        }
        return Constants.NOT_FOUND;
    }
}
