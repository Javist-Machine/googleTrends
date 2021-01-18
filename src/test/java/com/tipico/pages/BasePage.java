package com.tipico.pages;

import com.tipico.utils.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public  BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);


    }
}
