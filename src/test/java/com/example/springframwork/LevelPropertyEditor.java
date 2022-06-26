package com.example.springframwork;

import com.example.springframwork.dao.Level;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;

public class LevelPropertyEditor extends PropertyEditorSupport {

//    @InitBinder
//    public void initBinder(WebDataBinder dataBinder) {
//        dataBinder.registerCustomEditor(Level.class,new LevelPropertyEditor());
//    }

    @Override
    public String getAsText() {
        return String.valueOf(((Level) this.getValue()).intValue());
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        this.setValue(Level.valueOf(Integer.parseInt(text.trim())));
    }

}
