package com.assessment.data.model;

import java.io.Serializable;


import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

//@Embeddable
public class GradScoreCompositeKey  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3116865734001418107L;
	

	
//	@JoinColumn(name = "testId", nullable = false,referencedColumnName = "testId")
    private int  testId;

//    @JoinColumn(name = "employeeId", nullable = false,referencedColumnName = "employeeId")
    private int employeeId;


	

    
}