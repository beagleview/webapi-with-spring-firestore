package com.firebase.demo.firebasedemo.configs;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FirebaseConfig {
    public Firestore initializeFireBase() throws Exception {
        GoogleCredentials credentials = GoogleCredentials.getApplicationDefault();
        FirestoreOptions options = FirestoreOptions.newBuilder()
                .setCredentials(credentials)
                .setProjectId("java-firestore-demo-233514")
                .setTimestampsInSnapshotsEnabled(true).build();
        Firestore db = options.getService();
        return db;
    }
}
