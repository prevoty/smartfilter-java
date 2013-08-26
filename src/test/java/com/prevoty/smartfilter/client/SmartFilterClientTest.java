package com.prevoty.smartfilter.client;

import org.junit.Test;
import static org.junit.Assert.*;

public class SmartFilterClientTest {
    private String validApiKey = "valid api key goes here";
    private String invalidApiKey = "invalid key";
    private String validRuleKey = "valid rule key goes here";
    private String invalidRuleKey = "invalid key";
    private String input = "the <script>alert('quick brown fox');</script> jumps over the lazy dog & google.com";
    private String validUrlIdentifier = "valid url identifier";
    private String invaliddUrlIdentifier = "invalid url identifier";
    private String url = "http://google.com";

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

    @Test(expected = BadInputParameterException.class)
    public void testUrlInformationWithInvalidUrlIdentifier() throws NetworkException, BadApiKeyException, BadInputParameterException {
        SmartFilterClient client = new SmartFilterClient(validApiKey);
        client.UrlResults(invaliddUrlIdentifier);
    }

    @Test
    public void testUrlInformationWithValidUrlIdentifier() throws RequestTooLargeException, NetworkException, BadApiKeyException, AccountQuotaException, BadInputParameterException {
        SmartFilterClient client = new SmartFilterClient(validApiKey);
        UrlInformation urlInformation = client.UrlResults(validUrlIdentifier);
        assertEquals(url, urlInformation.url);
    }
}
