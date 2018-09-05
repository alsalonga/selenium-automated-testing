package mvp.cc.testing.CCTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Created by asalonga on 14/08/2018.
 */
public class Command {
    private WebDriver _driver;
    private Actions _actions;
    private WebDriverWait _wait;
    public Command(WebDriver driver){
        _driver = driver;
        _actions = new Actions(_driver);
        _wait = new WebDriverWait(_driver, 10);
    }

    public void perform(String tCase, String tAction, String screen, String tObject, String val){
        WebElement element;

        switch(tAction.toUpperCase()){
            case "SETVALUE":
                element = getElement(screen,tObject);
                if(tObject.equals("Type")){
                    _actions.moveToElement(element)
                            .doubleClick()
                            .sendKeys(val)
                            .sendKeys(Keys.TAB)
                            .perform();
                }else{
                    _actions.moveToElement(element)
                            .click()
                            .pause(500)
                            .sendKeys(val)
                            .perform();
                }
                break;
            case "CLICKBUTTON":
                switch(tObject){
                    case "Update":
                        _actions.pause(500);
                        _actions
                                .moveToElement(_wait.until(ExpectedConditions.elementToBeClickable(By.id("NewContactPopup:ContactDetailScreen:ContactBasicsDV_tb:ContactDetailToolbarButtonSet:CustomUpdateButton"))))
                                .click()
                                .perform();
                        break;
                    case "Next":
                        _actions.pause(500);
                        _actions
                                .moveToElement(_wait.until(ExpectedConditions.elementToBeClickable(By.id("FNOLWizard:Next"))))
                                .click()
                                .perform();
                        break;
                    case "Finish":
                        _actions.pause(1500);
                        _actions
                                .moveToElement(_wait.until(ExpectedConditions.elementToBeClickable(By.id("FNOLWizard:Finish"))))
                                .click()
                                .perform();
                        break;
                    default:
                        element = getElement(screen,tObject);
                        _actions
                                .moveToElement(element)
                                .click()
                                .perform();
                        break;
                }
                break;
            case "CLICKCLAIMTAB":
                element = _driver.findElement(By.id("TabBar:ClaimTab"));

                _actions.moveToElement(element)
                        .moveByOffset(20, 0)
                        .click()
                        .sendKeys(Keys.ARROW_DOWN)
                        .sendKeys(Keys.SPACE)
                        .perform();
                break;
            case "CREATEUNVERIFIEDCLAIM":
                element = _driver.findElement(By.id("FNOLWizard:FNOLWizard_FindPolicyScreen:ScreenMode_false-inputEl"));

                _actions.moveToElement(element)
                        .click()
                        .perform();
                break;
            case "NEWPERSON":
                String id = "FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:NewClaimPolicyGeneralPanelSet:NewClaimPolicyGeneralDV:Insured_Name:Insured_NameMenuIcon";
                _actions
                        .moveToElement(_driver.findElement(By.id(id)))
                        .click()
                        .sendKeys(Keys.SPACE)
                        .perform();
                break;
        }
        _actions.pause(500);
    }

    private WebElement getElement(String screen, String tObject){
        String format = "";
        switch(screen.toUpperCase()){
            case "LOGIN":
                format = "Login:LoginScreen:LoginDV:%s";
                break;
            case "FINDPOLICYSCREEN":
                format = "FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:%s-inputEl";
                break;
            case "FINDPOLICYSCREENDATE":
                format = "FNOLWizard:FNOLWizard_FindPolicyScreen:FNOLWizardFindPolicyPanelSet:NewClaimPolicyGeneralPanelSet:NewClaimPolicyGeneralDV:%s-inputEl";
                break;
            case "CONTACTDETAILSCREENPERSON":
                format = "NewContactPopup:ContactDetailScreen:ContactBasicsDV:PersonNameInputSet:GlobalPersonNameInputSet:%s-inputEl";
                break;
            case "CONTACTDETAILSCREENADDRESS":
                format = "NewContactPopup:ContactDetailScreen:ContactBasicsDV:PrimaryAddressInputSet:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:%s-inputEl";
                break;
            case "BASICINFOSCREEN":
                format = "FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_BasicInfoScreen:PanelRow:BasicInfoDetailViewPanelDV:%s-inputEl";
                break;
            case "NEWLOSSDETAILSSCREEN":
                format = "FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsPanel:FNOLWizard_NewLossDetailsPanelSet:NewLossDetailsHomeownersDV:%s-inputEl";
                break;
            case "NEWLOSSDETAILSSCREENADDRESS":
                format = "FNOLWizard:AutoWorkersCompWizardStepSet:FNOLWizard_NewLossDetailsScreen:LossDetailsPanel:FNOLWizard_NewLossDetailsPanelSet:NewLossDetailsHomeownersDV:AddressDetailInputSetRef:CCAddressInputSet:globalAddressContainer:globalAddress:GlobalAddressInputSet:%s-inputEl";
                break;
        }

        return _wait.until(ExpectedConditions.elementToBeClickable(_driver.findElement(By.id(String.format(format,tObject)))));
    }
}
