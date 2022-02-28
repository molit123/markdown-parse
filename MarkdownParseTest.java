import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinksTestFile() throws IOException {
        Path fileName = Path.of("testfiles/test-file.md");
        String contents = Files.readString(fileName);
        
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testGetLinksNoLinks() throws IOException {
        Path fileName = Path.of("no-links.md");
        String contents = Files.readString(fileName);
        
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testGetLinksImageLink() throws IOException {
        Path fileName = Path.of("image-link.md");
        String contents = Files.readString(fileName);
        
        assertEquals(List.of("https://something.com", "https://something.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testGetLinksBracketFile() throws IOException {
        Path fileName = Path.of("bracket-file.md");
        String contents = Files.readString(fileName);
        
        assertEquals(List.of(), MarkdownParse.getLinks(contents));
    }


    //-----------------------------------------PUBLIC TESTS--------------------------------------------------
    @Test
    public void testGetLinksTestFile2() throws IOException {
        Path fileName = Path.of("testfiles/test-file2.md");
        String contents = Files.readString(fileName);
        
        assertEquals(List.of("https://something.com","some-page.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet1() throws IOException {
        Path fileName = Path.of("testfiles/snippet-1.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of("google.com", "google.com", "ucsd.edu"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet2() throws IOException{
        Path fileName = Path.of("testfiles/snippet-2.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of("a.com", "a.com", "example.com"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testSnippet3() throws IOException{
        Path fileName = Path.of("testfiles/snippet-3.md");
        String contents = Files.readString(fileName);

        assertEquals(List.of("https://cse.ucsd.edu/"), MarkdownParse.getLinks(contents));
    }
     
    

    // @Test
    // public void testGetLinksTestFile3() throws IOException {
    //     Path fileName = Path.of("testfiles/test-file3.md");
    //     String contents = Files.readString(fileName);
        
    //     assertEquals(List.of(), MarkdownParse.getLinks(contents));
    // }

    // @Test
    // public void testGetLinksTestFile4() throws IOException {
    //     Path fileName = Path.of("testfiles/test-file4.md");
    //     String contents = Files.readString(fileName);
        
    //     assertEquals(List.of(), MarkdownParse.getLinks(contents));
    // }

    // @Test
    // public void testGetLinksTestFile5() throws IOException {
    //     Path fileName = Path.of("testfiles/test-file5.md");
    //     String contents = Files.readString(fileName);
        
    //     assertEquals(List.of(), MarkdownParse.getLinks(contents));
    // }
}
