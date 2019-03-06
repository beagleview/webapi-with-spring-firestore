package com.firebase.demo.firebasedemo.services;

import com.firebase.demo.firebasedemo.configs.FirebaseConfig;
import com.firebase.demo.firebasedemo.models.Member;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class FireBaseService {
    @Autowired
    FirebaseConfig firebase;

    Firestore db;

    public FireBaseService() throws Exception{
        firebase = new FirebaseConfig();
        this.db = firebase.initializeFireBase();
    }

    public void addMember(Member member){
        CollectionReference colRef = this.db.collection("member");
        Map<String, Member> data = new HashMap<>();
        data.put(UUID.randomUUID().toString() , member );
        ApiFuture<DocumentReference> result = colRef.add(data);
        //System.out.println(result.toString());
    }
}
