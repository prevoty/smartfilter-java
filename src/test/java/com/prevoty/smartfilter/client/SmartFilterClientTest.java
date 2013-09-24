package com.prevoty.smartfilter.client;

import org.junit.Test;
import static org.junit.Assert.*;

public class SmartFilterClientTest {
    private String validApiKey = "api key goes here";
    private String invalidApiKey = "invalid key";
    private String validRuleKey = "rule key goes here";
    private String invalidRuleKey = "invalid key";
    private String input = "the <script>alert('quick brown fox');</script> jumps over the lazy dog & http://prevoty.com";
    private String validUrlIdentifier = "http://prevoty.com";

    // Key Verification

    @Test(expected = BadApiKeyException.class)
    public void testVerifyForInvalidKeyFails() throws RequestTooLargeException, NetworkException, BadApiKeyException, AccountQuotaException, BadInputParameterException {
        SmartFilterClient client = new SmartFilterClient(invalidApiKey);
        client.Verify();
    }

    @Test
    public void testVerifyForValidApiKeyWorks() throws RequestTooLargeException, NetworkException, BadApiKeyException, AccountQuotaException, BadInputParameterException {
        SmartFilterClient client = new SmartFilterClient(validApiKey);
        assertTrue(client.Verify());
    }

    // Key Info

    @Test(expected = BadApiKeyException.class)
    public void testInfoForInvalidApiKeyFails() throws RequestTooLargeException, NetworkException, BadApiKeyException, AccountQuotaException, BadInputParameterException {
        SmartFilterClient client = new SmartFilterClient(invalidApiKey);
        client.Info();
    }

    @Test
    public void testInfoForValidApiKeyWorks() throws RequestTooLargeException, NetworkException, BadApiKeyException, AccountQuotaException, BadInputParameterException {
        SmartFilterClient client = new SmartFilterClient(validApiKey);
        InfoResult result = client.Info();
        assertEquals("api_key is valid", result.message);
    }

    // Rule Verify

    @Test(expected = BadInputParameterException.class)
    public void testRuleVerifyForInvalidRuleKeyFails() throws RequestTooLargeException, NetworkException, BadApiKeyException, AccountQuotaException, BadInputParameterException {
        SmartFilterClient client = new SmartFilterClient(validApiKey);
        client.VerifyRule(invalidRuleKey);
    }

    @Test
    public void testRuleVerifyForValidRuleKeyWorks() throws RequestTooLargeException, NetworkException, BadApiKeyException, AccountQuotaException, BadInputParameterException {
        SmartFilterClient client = new SmartFilterClient(validApiKey);
        assertTrue(client.VerifyRule(validRuleKey));
    }

    // Filter

    @Test
    public void testFilterWithValidApiAndRuleKeys() throws RequestTooLargeException, NetworkException, BadApiKeyException, AccountQuotaException, BadInputParameterException {
        SmartFilterClient client = new SmartFilterClient(validApiKey);
        FilterResult result = client.Filter(input, validRuleKey);
        assertEquals(0, result.statistics.javascript_attributes);
        assertEquals(0, result.statistics.javascript_protocols);
        assertEquals(2, result.statistics.javascript_tags);
        assertEquals(0, result.statistics.tags_balanced);
    }

    // URL Results

    @Test
    public void testUrlInformationWithValidUrlIdentifier() throws RequestTooLargeException, NetworkException, BadApiKeyException, AccountQuotaException, BadInputParameterException {
        SmartFilterClient client = new SmartFilterClient(validApiKey);
        UrlInformation urlInformation = client.UrlResults(validUrlIdentifier);
        assertEquals(validUrlIdentifier, urlInformation.analysis.url);
    }
}
