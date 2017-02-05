import com.websearch.WebSearch;
import com.websearch.printer.Printer;
import com.websearch.reader.Reader;
import com.websearch.result.Result;
import com.websearch.searcher.Searcher;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class WebSearchTest {


    @Test
    public void shouldInvokeReadSearchPrint() throws Exception {
        Reader reader = mock(Reader.class);
        Searcher searcher = mock(Searcher.class);
        Printer printer = mock(Printer.class);
        WebSearch webSearch = new WebSearch(reader, searcher, printer);

        webSearch.execute();

        String userInput = verify(reader).readUserInput();
        Result result = verify(searcher).search("sdf");
        verify(printer).print(result);
    }

}