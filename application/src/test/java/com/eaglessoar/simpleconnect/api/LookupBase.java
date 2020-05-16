package com.eaglessoar.simpleconnect.api;

import com.eaglessoar.simpleconnect.api.model.LookupRequest;
import com.eaglessoar.simpleconnect.api.model.LookupResponse;
import com.eaglessoar.simpleconnect.api.model.LookupResponsePage;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import io.restassured.module.mockmvc.config.MockMvcConfig;
import io.restassured.module.mockmvc.config.RestAssuredMockMvcConfig;
import org.junit.Before;
import org.springframework.http.ResponseEntity;

public class LookupBase {

    @Before
    public void setup() {
        RestAssuredMockMvc.config = new RestAssuredMockMvcConfig().mockMvcConfig(MockMvcConfig.mockMvcConfig());
        RestAssuredMockMvc.standaloneSetup(new LookupApiController(new LookupApiDelegate() {

            @Override
            public ResponseEntity<LookupResponse> lookupPost(LookupRequest lookupRequest) {
                return ResponseEntity.ok(new LookupResponse());
            }

            @Override
            public ResponseEntity<LookupResponsePage> lookupGet() {
                return ResponseEntity.ok(new LookupResponsePage());
            }

            @Override
            public ResponseEntity<LookupResponse> lookupUuidGet(String uuid) {
                return ResponseEntity.ok(new LookupResponse());
            }

            @Override
            public ResponseEntity<LookupResponse> lookupUuidPut(String uuid, LookupRequest lookupRequest) {
                return ResponseEntity.ok(new LookupResponse());
            }
        }));
    }
}
