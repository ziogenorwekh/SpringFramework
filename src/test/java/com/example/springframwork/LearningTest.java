package com.example.springframwork;


import com.example.springframwork.dao.Level;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.propertyeditors.CharsetEditor;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.web.bind.WebDataBinder;

import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.*;

//@SpringJUnitConfig(SpringConfig.class)
public class LearningTest {

    LevelPropertyEditor levelPropertyEditor;

    public LearningTest() {
        levelPropertyEditor = new LevelPropertyEditor();
    }

    @Test
    public void charsetEditor() {
        CharsetEditor charsetEditor = new CharsetEditor();
        charsetEditor.setAsText("UTF-8");
        assertThat(charsetEditor.getValue()).isInstanceOf(Charset.class);
        assertThat((Charset) charsetEditor.getValue()).isEqualTo(Charset.forName("UTF-8"));
    }

    @Test
    public void 알맞게변하는가요() {
        levelPropertyEditor.setAsText("3");
        assertThat((Level) levelPropertyEditor.getValue()).isEqualTo(Level.GOLD);

        levelPropertyEditor.setValue(Level.BASIC);
        assertThat(levelPropertyEditor.getAsText()).isEqualTo("1");
    }

    @Test
    public void webDataBinderTest() {
        WebDataBinder dataBinder = new WebDataBinder(null);
        dataBinder.registerCustomEditor(Level.class, new LevelPropertyEditor());
        assertThat(dataBinder.convertIfNecessary("1", Level.class)).isEqualTo(Level.BASIC);
    }
}
