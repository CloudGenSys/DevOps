package CGDemo.BPM;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2016-09-09 13:18:27 EDT
// -----( ON-HOST: windows-vultr

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.util.Calendar;
import java.io.*;
import java.util.Date;
// --- <<IS-END-IMPORTS>> ---

public final class utils

{
	// ---( internal utility methods )---

	final static utils _instance = new utils();

	static utils _newInstance() { return new utils(); }

	static utils _cast(Object o) { return (utils)o; }

	// ---( server methods )---




	public static final void threeMinuteDelay (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(threeMinuteDelay)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [o] object:0:required expDate
		// pipeline
		
		IDataCursor pipelineCursor = pipeline.getCursor();
		
		Calendar cal = Calendar.getInstance();
		
		cal.add(Calendar.MINUTE, 3);
		
		Date expDate = cal.getTime();
		
		// pipeline
		
		IDataUtil.put( pipelineCursor, "expDate", expDate );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void writeStringToFile (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(writeStringToFile)>> ---
		// @subtype unknown
		// @sigtype java 3.5
		// [i] field:0:required xmldata
		
		// pipeline
		IDataCursor pipelineCursor = pipeline.getCursor();
		String fileName = null;
		String orderID = null;
		
			// OrderRequest/PurchaseOrderRequest/thisDocumentIdentifier/ProprietaryDocumentIdentifier
			IData	OrderRequest = IDataUtil.getIData( pipelineCursor, "OrderRequest" );
			if ( OrderRequest != null)
			{
				IDataCursor OrderRequestCursor = OrderRequest.getCursor();
		
					// i.PurchaseOrderRequest
					IData	PurchaseOrderRequest = IDataUtil.getIData( OrderRequestCursor, "PurchaseOrderRequest" );
					if ( PurchaseOrderRequest != null)
					{
						IDataCursor PurchaseOrderRequestCursor = PurchaseOrderRequest.getCursor();
		
							// i_1.thisDocumentIdentifier
							IData	thisDocumentIdentifier = IDataUtil.getIData( PurchaseOrderRequestCursor, "thisDocumentIdentifier" );
							if ( thisDocumentIdentifier != null)
							{
								IDataCursor thisDocumentIdentifierCursor = thisDocumentIdentifier.getCursor();
								orderID = IDataUtil.getString( thisDocumentIdentifierCursor, "ProprietaryDocumentIdentifier" );
								thisDocumentIdentifierCursor.destroy();
							}					
						PurchaseOrderRequestCursor.destroy();
					}
		
				OrderRequestCursor.destroy();
			}
		
		
			try
			{
				String orderRequestStr = IDataUtil.getString( pipelineCursor, "xmldata" ); 
				Calendar cal = Calendar.getInstance();
				fileName = "C:\\temp\\log_" + orderID + "_" + cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DAY_OF_MONTH) + "-" + cal.get(Calendar.HOUR_OF_DAY) + "-" + cal.get(Calendar.MINUTE) +"-"+ cal.get(Calendar.SECOND) ;
				boolean success = (new File("C:\\temp")).mkdir();
				FileWriter writer = new FileWriter(fileName, true);
				BufferedWriter output = new BufferedWriter(writer);
		
				output.write(orderRequestStr);
				output.close();
			}
			catch (Exception e)
			{
				System.err.println("Error writing to a file");
			}
		
		// pipeline
		IDataUtil.put( pipelineCursor, "fileName", fileName );
		pipelineCursor.destroy();
		// --- <<IS-END>> ---

                
	}
}

