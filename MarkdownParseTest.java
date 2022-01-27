import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinks() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testGetLinks2() throws IOException {
        Path fileName = Path.of("no-links.md");
        String contents = Files.readString(fileName);
        
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testGetLinks3() throws IOException {
        Path fileName = Path.of("image-link.md");
        String contents = Files.readString(fileName);
        
        assertEquals(List.of("https://something.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testGetLinks4() throws IOException {
        Path fileName = Path.of("bracket-file.md");
        String contents = Files.readString(fileName);
        
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }
}
