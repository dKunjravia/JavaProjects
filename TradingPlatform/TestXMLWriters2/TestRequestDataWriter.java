package com.fdm.TestXMLWriters2;

import org.junit.Before;
import org.junit.Test;

import com.fdm.RequestDataClasses.RequestData;
import com.fdm.RequestsManagement.Requests;
import com.fdm.XMLWriters.RequestDataWriter;

public class TestRequestDataWriter {
	Requests request;
	RequestData requestData= RequestData.getInstance();
	RequestDataWriter userDataWrite= new RequestDataWriter();
	@Before
	public void initialize()
	{
		request= new Requests();
		request.setUsername("Greg");
		request.setAdminName("Dean");
		request.setStatus("Outstanding");
		request.setRequestText("Register");
		requestData.addRequest(request);
		request= new Requests();
		request.setUsername("Hansam");
		request.setAdminName("Dean");
		request.setStatus("Completed");
		request.setRequestText("Change Status to Admin");
		requestData.addRequest(request);
	}
	@Test
	public void testWriteData() {
		userDataWrite.writeData();
	}

}
