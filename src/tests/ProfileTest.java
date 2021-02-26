package tests;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProfileTest extends BasicTest {

	@Test (priority = 5)
	public void editPrpfileTest() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		this.driver.navigate().to(baseUrl + "/guest-user/login-form");
		this.lpp.getCloseBtn().click();
		this.lp.login(this.ussername, this.password);
		sa.assertEquals(this.nsp.message(), "Login Successfull" , "[ERROR] Unexpected login message" );
		
		this.driver.navigate().to(baseUrl + "/member/profile");
		this.pp.changePersonalImformation("Damjan", "Ivanovic", "Queens Boulevard ", "0696468166", "11250", "United States", "New York", "New York");
		sa.assertEquals(this.nsp.message(), "Setup Successful" , "[ERROR] There was a problem with saving profile");
		
		this.ap.logOut();
		sa.assertEquals(this.nsp.message(),  "Logout Successfull!" , "[ERROR] There was a problem with logingout" );
		
		sa.assertAll();
	}
	
	@Test (priority = 10)
	public void  changeProfileImageTest () throws InterruptedException, IOException {
		SoftAssert sa = new SoftAssert();
		this.driver.navigate().to(baseUrl + "/guest-user/login-form");
		this.lpp.getCloseBtn().click();
		this.lp.login(this.ussername, this.password);
		sa.assertEquals(this.nsp.message(), "Login Successfull" , "[ERROR] Unexpected login message" );
		
		this.driver.navigate().to(baseUrl + "/member/profile");
		String imgPath = new File("img/slika.jpg").getCanonicalPath();
		Thread.sleep(2000);
		this.pp.uploadImg(imgPath);
		sa.assertEquals(this.nsp.message(),  "Profile Image Uploaded Successfully" , "[ERROR] Picture is not uploaded ");
		this.nsp.waitMessageToDisapire();
		this.pp.removeProfileImage();
		sa.assertEquals(this.nsp.message(), "Profile Image Deleted Successfully" , "[ERROR] Picture is not deleted");
		
		this.ap.logOut();
		sa.assertEquals(this.nsp.message(),  "Logout Successfull!" , "[ERROR] There was a problem with logingout" );
		sa.assertAll();
	}
	
	
}
