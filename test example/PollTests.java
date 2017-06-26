package core.test.MembershipTests;

import core.MembershipPages.MembershipMain;
import core.MembershipPages.PollPages.CreateNewPoll;
import core.MembershipPages.PollPages.TestSteps.TestDetailPollPage;
import core.MembershipPages.SurveyPages.PreviewSurveyPage;
import core.Obj.MembershipObjects.SurvayObject;
import core.helpers.MembershipHelper;
import core.helpers.WaitHelper;
import framework.cuCore.CUVerification;
import framework.cuCore.CU_AdvancedBaseClass;
import framework.cuResultLog.RES;
import org.testng.annotations.Test;

/**
 * Created by Stanislav_Variukhno on 6/22/2017.
 */
public class PollTests extends CU_AdvancedBaseClass {


    public String  CurrentURL="http://crmembershipweb1qa1.crinfra.net/admin/login";//"http://crmembershipweb1dev1.crinfra.net/admin/login";
    //http://crmembershipweb1qa1.crinfra.net/admin/login

    //Widget creation tests
    @Test(description = "Cover image is empty")
    public void tVerifyPollCoverimageisempty() {
        Driver.Invoke(CurrentURL);
        MembershipHelper helper = new MembershipHelper(Driver);
        MembershipMain membershipMain = new MembershipMain(Driver);
        CreateNewPoll createNewPoll = new CreateNewPoll(Driver);
        TestDetailPollPage testDetailPollPage = new TestDetailPollPage(Driver);
        RES.LogStep("Cover image is empty");
        helper.Login();
        membershipMain.pressPolls();
        membershipMain.pressSurveysCreateNewUI();
        createNewPoll.setTitle("asdf");
        createNewPoll.setShortTitle("asdf");
        createNewPoll.setParentArticleURL("http://asdf");
        createNewPoll.pressCreateTestBtnUI();
        testDetailPollPage.pressPreviewTestBtnUI();
        PreviewSurveyPage previewSurveyPage = new PreviewSurveyPage(Driver);
        CUVerification.softVerifyValue(
                "Make sure that widget doesn't contain cover image",
                previewSurveyPage.getImageSectionUI().getCssValue("background-image").equals("none"), sAssert);
    }


    @Test(description = "Standard asset is displayed in Cover image placeholder")
    public void tVerifyPollCoverimageisStandard() {
        Driver.Invoke(CurrentURL);
        MembershipHelper helper = new MembershipHelper(Driver);
        MembershipMain membershipMain = new MembershipMain(Driver);
        CreateNewPoll createNewPoll = new CreateNewPoll(Driver);
        TestDetailPollPage testDetailPollPage = new TestDetailPollPage(Driver);
        RES.LogStep("Standard asset is displayed in Cover image placeholder");
        SurvayObject survayObject = new SurvayObject();
        survayObject.FillWithDefaultValues();
        survayObject.setTestTitle("Auto_Cloudinary_default_image");
        helper.Login();
        membershipMain.pressPolls();
        membershipMain.pressSurveysCreateNewUI();
        createNewPoll.setTitle("asdf");
        createNewPoll.setShortTitle("asdf");
        createNewPoll.setParentArticleURL("http://asdf");
        createNewPoll.setShowCoverImageYes();
        createNewPoll.pressCreateTestBtnUI();
        testDetailPollPage.pressPreviewTestBtnUI();
        PreviewSurveyPage previewSurveyPage = new PreviewSurveyPage(Driver);
        RES.LogStep(previewSurveyPage.getImageSectionUI().getCssValue("background-image"));
        CUVerification.softVerifyValue(
                "Make sure that widget contain default cover image",
                previewSurveyPage.getImageSectionUI().getCssValue("background-image").equals("url(\"http://crmembershipweb1qa1.crinfra.net/assets/utest/default_cover_image.png\")"), sAssert);

    }

    @Test(description = "Chosen by user image is displayed")
    public void tVerifyPollCoverimageisChosen() {
        Driver.Invoke(CurrentURL);
        MembershipHelper helper = new MembershipHelper(Driver);
        MembershipMain membershipMain = new MembershipMain(Driver);
        CreateNewPoll createNewPoll = new CreateNewPoll(Driver);
        TestDetailPollPage testDetailPollPage = new TestDetailPollPage(Driver);
        RES.LogStep("Chosen by user image is displayed");
        SurvayObject survayObject = new SurvayObject();
        survayObject.FillWithDefaultValues();
        survayObject.setTestTitle("Auto_Cloudinary_chosen_image");
        helper.Login();
        membershipMain.pressPolls();
        membershipMain.pressSurveysCreateNewUI();
        createNewPoll.setTitle("asdf");
        createNewPoll.setShortTitle("asdf");
        createNewPoll.setParentArticleURL("http://asdf");
        createNewPoll.setShowCoverImageYes();
        createNewPoll.setCoverImageSearchUI("CR-Money-Hero-May-Deep-Discount-v2-0417");
        createNewPoll.setCoverImageSearchBtnUI();
        createNewPoll.selectFirstImageUI();
        createNewPoll.pressCreateTestBtnUI();
        testDetailPollPage.pressPreviewTestBtnUI();
        PreviewSurveyPage previewSurveyPage = new PreviewSurveyPage(Driver);
        RES.LogStep(previewSurveyPage.getImageSectionUI().getCssValue("background-image"));
        CUVerification.softVerifyValue(
                "Make sure that widget contain default cover image",
                previewSurveyPage.getImageSectionUI().getCssValue("background-image").equals("url(\"http://res.cloudinary.com/consumer-reports-cld/dev/content/dam/CRO%20Images%202017/Money/April/CR-Money-Hero-May-Deep-Discount-v2-0417\")"), sAssert);


    }


    @Test(description = "Image is deleted from image placeholder after click \"Remove\" button")
    public void tVerifyPollCoverimageisRemoved() {
        Driver.Invoke(CurrentURL);
        MembershipHelper helper = new MembershipHelper(Driver);
        MembershipMain membershipMain = new MembershipMain(Driver);
        CreateNewPoll createNewPoll = new CreateNewPoll(Driver);
        TestDetailPollPage testDetailPollPage = new TestDetailPollPage(Driver);
        RES.LogStep("Image is deleted from image placeholder after click \"Remove\" button");
        SurvayObject survayObject = new SurvayObject();
        survayObject.FillWithDefaultValues();
        survayObject.setTestTitle("Auto_Cloudinary_image_remove");
        helper.Login();
        membershipMain.pressPolls();
        membershipMain.pressSurveysCreateNewUI();
        createNewPoll.setTitle("asdf");
        createNewPoll.setShortTitle("asdf");
        createNewPoll.setParentArticleURL("http://asdf");

        createNewPoll.setShowCoverImageYes();
        createNewPoll.setCoverImageSearchUI("CR-Money-Hero-May-Deep-Discount-v2-0417");
        createNewPoll.setCoverImageSearchBtnUI();
        createNewPoll.selectFirstImageUI();
        createNewPoll.setCoverImageRemoveBtnUI();
        createNewPoll.pressCreateTestBtnUI();
        testDetailPollPage.pressPreviewTestBtnUI();
        PreviewSurveyPage previewSurveyPage = new PreviewSurveyPage(Driver);
        RES.LogStep(previewSurveyPage.getImageSectionUI().getCssValue("background-image"));
        CUVerification.softVerifyValue(
                "Make sure that widget contain default cover image",
                previewSurveyPage.getImageSectionUI().getCssValue("background-image").equals("url(\"http://crmembershipweb1qa1.crinfra.net/assets/utest/default_cover_image.png\")"), sAssert);

    }

    @Test(description = "Image is deleted from image placeholder after click X button")
    public void tVerifyPollCoverimageisRemovedX() {
        Driver.Invoke(CurrentURL);
        MembershipHelper helper = new MembershipHelper(Driver);
        MembershipMain membershipMain = new MembershipMain(Driver);
        CreateNewPoll createNewPoll = new CreateNewPoll(Driver);
        TestDetailPollPage testDetailPollPage = new TestDetailPollPage(Driver);
        RES.LogStep("Image is deleted from image placeholder after click X button");
        SurvayObject survayObject = new SurvayObject();
        survayObject.FillWithDefaultValues();
        survayObject.setTestTitle("Auto_Cloudinary_image_remove(X)");
        helper.Login();
        membershipMain.pressPolls();
        membershipMain.pressSurveysCreateNewUI();
        createNewPoll.setTitle("asdf");
        createNewPoll.setShortTitle("asdf");
        createNewPoll.setParentArticleURL("http://asdf");

        createNewPoll.setShowCoverImageYes();
        createNewPoll.setCoverImageSearchUI("CR-Money-Hero-May-Deep-Discount-v2-0417");
        createNewPoll.setCoverImageSearchBtnUI();
        createNewPoll.selectFirstImageUI();
        helper.RemoveImageX();
        createNewPoll.pressCreateTestBtnUI();
        testDetailPollPage.pressPreviewTestBtnUI();
        PreviewSurveyPage previewSurveyPage = new PreviewSurveyPage(Driver);
        RES.LogStep(previewSurveyPage.getImageSectionUI().getCssValue("background-image"));
        CUVerification.softVerifyValue(
                "Make sure that widget contain default cover image",
                previewSurveyPage.getImageSectionUI().getCssValue("background-image").equals("url(\"http://crmembershipweb1qa1.crinfra.net/assets/utest/default_cover_image.png\")"), sAssert);
    }

    @Test(description = "4 more results are loaded after click \"Load more\" button")
    public void tVerifyPollCoverimageisLoadMore() {
        Driver.Invoke(CurrentURL);
        MembershipHelper helper = new MembershipHelper(Driver);
        MembershipMain membershipMain = new MembershipMain(Driver);
        CreateNewPoll createNewPoll = new CreateNewPoll(Driver);
        TestDetailPollPage testDetailPollPage = new TestDetailPollPage(Driver);
        RES.LogStep("4 more results are loaded after click \"Load more\" buttonn");
        SurvayObject survayObject = new SurvayObject();
        survayObject.FillWithDefaultValues();
        survayObject.setTestTitle("Auto_Cloudinary_image_load_more");
        helper.Login();
        membershipMain.pressPolls();
        membershipMain.pressSurveysCreateNewUI();
        createNewPoll.setTitle("asdf");
        createNewPoll.setShortTitle("asdf");
        createNewPoll.setParentArticleURL("http://asdf");

        createNewPoll.setShowCoverImageYes();
        createNewPoll.setCoverImageSearchUI("CR-Money-Hero-May-Deep-Discount-v2-0417");
        createNewPoll.setCoverImageSearchBtnUI();
        helper.LoadMoreImages();

        CUVerification.softVerifyValue(
                "Make sure that widget contain default cover image",
                helper.getImagesCount()==4, sAssert);
    }


    //Widget editing - cover image
    @Test(description = "Image is deleted from image placeholder after click \"Remove\" button")
    public void tVerifyPollImageremoveedit() {
        Driver.Invoke(CurrentURL);
        MembershipHelper helper = new MembershipHelper(Driver);
        MembershipMain membershipMain = new MembershipMain(Driver);
        CreateNewPoll createNewPoll = new CreateNewPoll(Driver);
        TestDetailPollPage testDetailPollPage = new TestDetailPollPage(Driver);

        SurvayObject survayObject = new SurvayObject();
        RES.LogStep("Auto_Cloudinary_image_remove_edit");
        survayObject.FillWithDefaultValues();
        survayObject.setTestTitle("Auto_Cloudinary_image_remove_edit");
        helper.Login();
        membershipMain.pressPolls();
        membershipMain.pressSurveysCreateNewUI();
        createNewPoll.setTitle("asdf");
        createNewPoll.setShortTitle("asdf");
        createNewPoll.setParentArticleURL("http://asdf");

        helper.IsShowCoverImage(false);
        createNewPoll.pressCreateTestBtnUI();
        helper.FindSurveyAndEnterByTitle(survayObject.getTestTitle());
        createNewPoll.setShowCoverImageYes();
        createNewPoll.setCoverImageSearchUI("CR-Money-Hero-May-Deep-Discount-v2-0417");
        createNewPoll.setCoverImageSearchBtnUI();
        createNewPoll.selectFirstImageUI();
        createNewPoll.setCoverImageRemoveBtnUI();
        helper.SaveChanges();
        testDetailPollPage.pressPreviewTestBtnUI();
        PreviewSurveyPage previewSurveyPage = new PreviewSurveyPage(Driver);
        RES.LogStep(previewSurveyPage.getImageSectionUI().getCssValue("background-image"));
        CUVerification.softVerifyValue(
                "Make sure that widget contain default cover image",
                previewSurveyPage.getImageSectionUI().getCssValue("background-image").equals("url(\"http://crmembershipweb1qa1.crinfra.net/assets/utest/default_cover_image.png\")"), sAssert);

    }

    @Test(description = "Image is deleted from image placeholder after click X button")
    public void tVerifyPollImageremovexedit() {
        Driver.Invoke(CurrentURL);
        MembershipHelper helper = new MembershipHelper(Driver);
        MembershipMain membershipMain = new MembershipMain(Driver);
        CreateNewPoll createNewPoll = new CreateNewPoll(Driver);
        TestDetailPollPage testDetailPollPage = new TestDetailPollPage(Driver);
        SurvayObject survayObject = new SurvayObject();
        RES.LogStep("Auto_Cloudinary_image_remove_edit");
        survayObject.FillWithDefaultValues();
        survayObject.setTestTitle("\"Auto_Cloudinary_image_remove(X)_edit");
        helper.Login();
        membershipMain.pressPolls();
        membershipMain.pressSurveysCreateNewUI();
        createNewPoll.setTitle("asdf");
        createNewPoll.setShortTitle("asdf");
        createNewPoll.setParentArticleURL("http://asdf");

        helper.IsShowCoverImage(false);
        createNewPoll.pressCreateTestBtnUI();
        helper.FindSurveyAndEnterByTitle(survayObject.getTestTitle());
        createNewPoll.setShowCoverImageYes();
        createNewPoll.setCoverImageSearchUI("CR-Money-Hero-May-Deep-Discount-v2-0417");
        createNewPoll.setCoverImageSearchBtnUI();
        createNewPoll.selectFirstImageUI();
        helper.RemoveImageX();
        helper.SaveChanges();
        testDetailPollPage.pressPreviewTestBtnUI();
        PreviewSurveyPage previewSurveyPage = new PreviewSurveyPage(Driver);
        RES.LogStep(previewSurveyPage.getImageSectionUI().getCssValue("background-image"));
        CUVerification.softVerifyValue(
                "Make sure that widget contain default cover image",
                previewSurveyPage.getImageSectionUI().getCssValue("background-image").equals("url(\"http://crmembershipweb1qa1.crinfra.net/assets/utest/default_cover_image.png\")"), sAssert);
    }

    @Test(description = "4 more results are loaded after click \"Load more\" button")
    public void tVerifyPollloadmoreedit() {
        Driver.Invoke(CurrentURL);
        MembershipHelper helper = new MembershipHelper(Driver);
        MembershipMain membershipMain = new MembershipMain(Driver);
        CreateNewPoll createNewPoll = new CreateNewPoll(Driver);
        TestDetailPollPage testDetailPollPage = new TestDetailPollPage(Driver);
        SurvayObject survayObject = new SurvayObject();
        RES.LogStep("Auto_Cloudinary_image_remove_edit");
        survayObject.FillWithDefaultValues();
        survayObject.setTestTitle("Auto_Cloudinary_image_remove_edit");
        helper.Login();
        membershipMain.pressPolls();
        membershipMain.pressSurveysCreateNewUI();
        createNewPoll.setTitle("asdf");
        createNewPoll.setShortTitle("asdf");
        createNewPoll.setParentArticleURL("http://asdf");

        helper.IsShowCoverImage(false);
        createNewPoll.pressCreateTestBtnUI();
        helper.FindSurveyAndEnterByTitle(survayObject.getTestTitle());
        createNewPoll.setShowCoverImageYes();
        createNewPoll.setCoverImageSearchUI("CR-Money-Hero-May-Deep-Discount-v2-0417");
        createNewPoll.setCoverImageSearchBtnUI();
        helper.LoadMoreImages();
        CUVerification.softVerifyValue(
                "Make sure that widget contain default cover image",
                helper.getImagesCount()==4, sAssert);
    }

    @Test(description = "Add cover image")
    public void tVerifyPollchosenimageedit() {
        Driver.Invoke(CurrentURL);
        MembershipHelper helper = new MembershipHelper(Driver);
        MembershipMain membershipMain = new MembershipMain(Driver);
        CreateNewPoll createNewPoll = new CreateNewPoll(Driver);
        TestDetailPollPage testDetailPollPage = new TestDetailPollPage(Driver);

        SurvayObject survayObject = new SurvayObject();
        RES.LogStep("Auto_Cloudinary_image_remove_edit");
        survayObject.FillWithDefaultValues();
        survayObject.setTestTitle("Auto_Cloudinary_image_remove_edit");
        helper.Login();
        membershipMain.pressPolls();
        membershipMain.pressSurveysCreateNewUI();
        createNewPoll.setTitle("asdf");
        createNewPoll.setShortTitle("asdf");
        createNewPoll.setParentArticleURL("http://asdf");

        helper.IsShowCoverImage(false);
        createNewPoll.pressCreateTestBtnUI();
        helper.FindSurveyAndEnterByTitle(survayObject.getTestTitle());
        createNewPoll.setShowCoverImageYes();
        createNewPoll.setCoverImageSearchUI("CR-Money-Hero-May-Deep-Discount-v2-0417");
        createNewPoll.setCoverImageSearchBtnUI();
        createNewPoll.selectFirstImageUI();
        createNewPoll.pressCreateTestBtnUI();
        testDetailPollPage.pressPreviewTestBtnUI();
        PreviewSurveyPage previewSurveyPage = new PreviewSurveyPage(Driver);
        RES.LogStep(previewSurveyPage.getImageSectionUI().getCssValue("background-image"));
        CUVerification.softVerifyValue(
                "Make sure that widget contain default cover image",
                previewSurveyPage.getImageSectionUI().getCssValue("background-image").equals("url(\"http://res.cloudinary.com/consumer-reports-cld/dev/content/dam/CRO%20Images%202017/Money/April/CR-Money-Hero-May-Deep-Discount-v2-0417\")"), sAssert);

    }

    @Test(description = "Replacement of cover image")
    public void tVerifyPollimagereplacementedit() {
        Driver.Invoke(CurrentURL);
                MembershipHelper helper = new MembershipHelper(Driver);         MembershipMain membershipMain = new MembershipMain(Driver);         CreateNewPoll createNewPoll = new CreateNewPoll(Driver);         TestDetailPollPage testDetailPollPage = new TestDetailPollPage(Driver);
        RES.LogStep("Standard asset is displayed in Cover image plytaceholder");
        SurvayObject survayObject = new SurvayObject();
        survayObject.FillWithDefaultValues();
        survayObject.setTestTitle("Auto_Cloudinary_image_replacement_edit");
        helper.Login();
        membershipMain.pressPolls();
        membershipMain.pressSurveysCreateNewUI();
        createNewPoll.setTitle("asdf");
        createNewPoll.setShortTitle("asdf");
        createNewPoll.setParentArticleURL("http://asdf");

        createNewPoll.setShowCoverImageYes();
        createNewPoll.pressCreateTestBtnUI();
        helper.FindSurveyAndEnterByTitle(survayObject.getTestTitle());
        createNewPoll.setCoverImageSearchUI("CR-Money-Hero-May-Deep-Discount-v2-0417");
        createNewPoll.setCoverImageSearchBtnUI();
        createNewPoll.selectFirstImageUI();
        createNewPoll.setCoverImageRemoveBtnUI();
        helper.SaveChanges();
        PreviewSurveyPage previewSurveyPage = new PreviewSurveyPage(Driver);
        RES.LogStep(previewSurveyPage.getImageSectionUI().getCssValue("background-image"));
        CUVerification.softVerifyValue(
                "Make sure that widget contain default cover image",
                previewSurveyPage.getImageSectionUI().getCssValue("background-image").equals("url(\"http://res.cloudinary.com/consumer-reports-cld/dev/content/dam/CRO%20Images%202017/Money/April/CR-Money-Hero-May-Deep-Discount-v2-0417\")"), sAssert);

    }

    @Test(description = "Delete of image")
    public void tVerifyPollimagedeleteedit() {
        Driver.Invoke(CurrentURL);
        MembershipHelper helper = new MembershipHelper(Driver);
        MembershipMain membershipMain = new MembershipMain(Driver);
        CreateNewPoll createNewPoll = new CreateNewPoll(Driver);
        TestDetailPollPage testDetailPollPage = new TestDetailPollPage(Driver);
        RES.LogStep("Chosen by user image is displayed");
        SurvayObject survayObject = new SurvayObject();
        survayObject.FillWithDefaultValues();
        survayObject.setTestTitle("Auto_Cloudinary_chosen_image");
        helper.Login();
        membershipMain.pressPolls();
        membershipMain.pressSurveysCreateNewUI();
        createNewPoll.setTitle("asdf");
        createNewPoll.setShortTitle("asdf");
        createNewPoll.setParentArticleURL("http://asdf");
        createNewPoll.setShowCoverImageYes();
        createNewPoll.setCoverImageSearchUI("CR-Money-Hero-May-Deep-Discount-v2-0417");
        createNewPoll.setCoverImageSearchBtnUI();
        createNewPoll.selectFirstImageUI();
        createNewPoll.pressCreateTestBtnUI();
        helper.FindSurveyAndEnterByTitle(survayObject.getTestTitle());
        createNewPoll.setShowCoverImageYes();
        createNewPoll.setCoverImageRemoveBtnUI();
        new WaitHelper(Driver).sleep(20);
        helper.SaveChanges();
        testDetailPollPage.pressPreviewTestBtnUI();
        PreviewSurveyPage previewSurveyPage = new PreviewSurveyPage(Driver);
        RES.LogStep(previewSurveyPage.getImageSectionUI().getCssValue("background-image"));
        CUVerification.softVerifyValue(
                "Make sure that widget contain default cover image",
                previewSurveyPage.getImageSectionUI().getCssValue("background-image").equals("url(\"http://crmembershipweb1qa1.crinfra.net/assets/utest/default_cover_image.png\")"), sAssert);
    }


}
