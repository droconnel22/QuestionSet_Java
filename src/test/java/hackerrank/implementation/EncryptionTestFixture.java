package hackerrank.implementation;


import com.hackerrank.implementation.Encryption;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
@SpringBootTest
public class EncryptionTestFixture {

    private Encryption encryption;

    @Before
    public void Before(){
        encryption = new Encryption();
    }

    @Test
    @Parameters(method ="scenarios")
    public void run_given_examples(String input, String expected) throws Exception{
        assertEquals(expected, encryption.Encrypt(input));
    }

    private Object[] scenarios() {
        return new Object[]{
                new Object[]{
                        "chillout",
                        "clu hlt io"
                },
                new Object[]{
                  "feedthedog",
                  "fto ehg ee dd"

                },
                new Object[]{
                        "if man was meant to stay on the ground god would have given us roots",
                        "imtgdvs fearwer mayoogo anouuio ntnnlvt wttddes aohghn sseoau"

            }
        };
    }
}
