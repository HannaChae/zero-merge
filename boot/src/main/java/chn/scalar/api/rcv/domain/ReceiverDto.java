  
package chn.scalar.api.rcv.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component @Data @Lazy
public class ReceiverDto {
	 private long rcvNo;
	 private String rcvName;
     private String rcvPhone;
     private String rcvAddr;
     
}