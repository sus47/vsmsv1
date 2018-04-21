
package model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;


public class ConvertExamResultDetailToList {

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public float getThOm() {
        return thOm;
    }

    public void setThOm(float thOm) {
        this.thOm = thOm;
    }

    public float getPhOm() {
        return phOm;
    }

    public void setPhOm(float phOm) {
        this.phOm = phOm;
    }
   int subjectId;
   float thOm,phOm;

   

   
}


