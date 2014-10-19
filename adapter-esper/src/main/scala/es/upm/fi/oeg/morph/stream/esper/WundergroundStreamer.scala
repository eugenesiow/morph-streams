package es.upm.fi.oeg.morph.stream.esper
import es.upm.fi.oeg.morph.stream.wrapper.Wunderground

class WundergroundStreamer(stationid:String,extent:String,rate:Int) {
  //extends DemoStreamer(extent,rate,esper){
  private val wund=new Wunderground(stationid)
  private var latestTime:Long=0
   def generateData={
    val data=wund.getData
    if (data.internalTime>latestTime){
      latestTime=data.internalTime
	  Some(List("stationId"->data.stationId,	      
	     "internalTime"->data.internalTime,
	     "observationTime"->data.observationTime,
	     "airPressure"-> data.airPressure,
	     "temperature"->data.temperature,
	     "timestamp"-> data.windSpeed).toMap)	    
    }
	else None
  }
  
}