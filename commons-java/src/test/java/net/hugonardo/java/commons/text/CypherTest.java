package net.hugonardo.java.commons.text;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CypherTest {

    private Cypher mCypher;

    @Before
    public void setUp() throws Exception {
        mCypher = new Cypher();
    }

    @Test
    public void checkMd5() throws Exception {
        String md5 = mCypher.toMd5("022065");
        assertThat(md5, is("c7ec05991cc00f7c023b196b7be34d0b"));
    }

    @Test
    public void checkSha1() throws Exception {
        String sha1 = mCypher.toSha1("022065");
        assertThat(sha1, is("2a55ee5b6b57f319bba05ee2d480bace55ecc73e"));
    }
}