package jdev.dto;



import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class PointDTOTest {

    private String expected ="{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":1573136576145}";
    private String autoId = "o567gfd";

    @Test
    public void toJson() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(56);
        point.setLon(74);
        point.setAutoId("o567gfd");
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":56"));
        System.out.println(point.toJson());
    }

    @Test
    public void decodeDto() throws Exception{
        ObjectMapper mapper=new ObjectMapper();
        PointDTO dto = mapper.readValue(expected,PointDTO.class);
        assertEquals(1573136576145L,dto.getTime());
    }
}