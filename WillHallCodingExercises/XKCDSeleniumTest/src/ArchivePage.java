import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ArchivePage {
	private WebDriver driver;
	
	public ArchivePage(WebDriver w){
		driver = w;
	}
	
	public String getTitleOfArchivedComicByDepth(int i){
		return driver.findElement(By.xpath("//*[@id=\"middleContainer\"]/a["+i+"]")).getText();
	}
}
