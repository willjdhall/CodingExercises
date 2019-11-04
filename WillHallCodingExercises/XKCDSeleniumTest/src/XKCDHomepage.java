import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class XKCDHomepage {
	private WebDriver driver;
	private By previous = By.linkText("< Prev");
	private By comicTitle = By.id("ctitle");
	private By archiveLink = By.linkText("Archive");
	
	public XKCDHomepage(WebDriver w){
		driver = w;
		driver.get("https://xkcd.com");
	}
	
	public void clickPreviousButton(){
		driver.findElement(previous).click();
	}
	
	public String getComicTitle(){
		return driver.findElement(comicTitle).getText();
	}
	
	public ArchivePage goToArchivesPage(){
		driver.findElement(archiveLink).click();
		
		return new ArchivePage(driver);
	}
}
