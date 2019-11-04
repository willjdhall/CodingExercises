import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XKCDTests {
	WebDriver driver;
	
	@Before
	public void executeBefore(){
		try{
			System.setProperty("webdriver.chrome.driver", "chromedriver");
			driver = new ChromeDriver(); 
		}catch(Exception e){
			System.out.println("I'm sorry, I could not create a chromedriver for this reason");
			System.out.println(e.toString());
		}
	}
	
	@After
	public void executeAfter(){
		driver.quit();
	}
	
	@Test
	public void testThirdArchiveLink(){
		XKCDHomepage xkcd = new XKCDHomepage(driver);
		
		xkcd.clickPreviousButton();
		
		xkcd.clickPreviousButton();
		
		String comicTitle = xkcd.getComicTitle();
		System.out.println("The title of the comic that is diplayed is: " + comicTitle);
		
		ArchivePage archive = xkcd.goToArchivesPage();
		
		String thirdTitle = archive.getTitleOfArchivedComicByDepth(3);
		
		System.out.println("The title of the third comic listed on the archives page is: " + thirdTitle);
		
		assertTrue("Asserts that comic title found after clicking the previous button twice is equal to the third comic title on the archive page",
				comicTitle.equals(thirdTitle));
	}
}
