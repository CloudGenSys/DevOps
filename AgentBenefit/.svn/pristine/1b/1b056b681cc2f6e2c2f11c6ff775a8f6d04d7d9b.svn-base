package AgentBenefit;

// -----( IS Java Code Template v1.2
// -----( CREATED: 2015-09-03 04:03:15 EDT
// -----( ON-HOST: windows-vultr

import com.wm.data.*;
import com.wm.util.Values;
import com.wm.app.b2b.server.Service;
import com.wm.app.b2b.server.ServiceException;
// --- <<IS-START-IMPORTS>> ---
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
// --- <<IS-END-IMPORTS>> ---

public final class util

{
	// ---( internal utility methods )---

	final static util _instance = new util();

	static util _newInstance() { return new util(); }

	static util _cast(Object o) { return (util)o; }

	// ---( server methods )---




	public static final void parseDate (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(parseDate)>> ---
		// @sigtype java 3.5
		// [i] field:0:required dateString
		// [i] field:0:required dateFormat
		// [o] object:0:required dateValue
		IDataCursor pipelineInputCursor = pipeline.getCursor();  
		String dateString = IDataUtil.getString(pipelineInputCursor,"dateString");
		String dateFormat = IDataUtil.getString(pipelineInputCursor,"dateFormat");
		pipelineInputCursor.destroy();
			
		DateFormat format = new SimpleDateFormat(dateFormat);
		Date date = null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			throw new ServiceException(e);
		}
		
		IDataCursor pipelineOutputCursor = pipeline.getCursor();
		IDataUtil.put(pipelineOutputCursor, "dateValue",
				date);
		pipelineOutputCursor.destroy();
		// --- <<IS-END>> ---

                
	}



	public static final void throwException (IData pipeline)
        throws ServiceException
	{
		// --- <<IS-START(throwException)>> ---
		// @sigtype java 3.5
		// [i] field:0:required message
		IDataCursor inputCursor = pipeline.getCursor();
		String message = IDataUtil.getString(inputCursor, "message");
		inputCursor.destroy();
		
		throw new ServiceException(message);
		// --- <<IS-END>> ---

                
	}
}

