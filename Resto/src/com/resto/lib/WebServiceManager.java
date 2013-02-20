package com.resto.lib;

import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalBase64;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.widget.Toast;

public class WebServiceManager {
	
	public Object resultObject;
	public SoapObject GetIDTypes(String URL, String NAMESPACE,
			String METHOD_NAME, String SOAP_ACTION) {
		SoapObject checkcount_soap = null;
		try {
			SoapObject request_type = new SoapObject(NAMESPACE, METHOD_NAME);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			envelope.setOutputSoapObject(request_type);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION, envelope);
			checkcount_soap = (SoapObject) envelope.bodyIn;
			
			// checkcount_sp = (SoapObject) envelope.toString();
		} catch (Exception E) {
			E.getMessage();
			Toast.makeText(null, "ERROR GetRec" + E.getClass().getName()
					+ "exp GetRec" + E.getMessage(), Toast.LENGTH_LONG);
		}
		return checkcount_soap;
	}
	
	public Object SaveData(String URL, String NAMESPACE, String METHOD_NAME,
			String SOAP_ACTION,List<InsertionClass> insertionlist) throws Exception {
		try {
			SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
			SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
					SoapEnvelope.VER11);
			// Newly Added for Serialization new
			new MarshalBase64().register(envelope);
			envelope.encodingStyle = SoapEnvelope.ENC;
			
			for (int i=0;i<insertionlist.size();i++){
				InsertionClass insertobj=new InsertionClass();
				insertobj=insertionlist.get(i);
				request.addProperty("MSISDN"," MSISDN");
			}
			
			envelope.setOutputSoapObject(request);
			HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
			androidHttpTransport.call(SOAP_ACTION, envelope);
			resultObject = envelope.getResponse();
			
			/*Toast.makeText(null, " " + result, Toast.LENGTH_LONG).show();*/
		} catch (Exception E) {
			E.printStackTrace();
			Toast.makeText(
					null,
					"Saving Problem :Web Services ERROR" + E.getClass().getName() + ":"
							+ E.getMessage(), Toast.LENGTH_LONG).show();

		}
		return resultObject;
	}


}
