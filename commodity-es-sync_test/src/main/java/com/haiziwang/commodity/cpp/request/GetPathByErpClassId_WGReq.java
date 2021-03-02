 
 
//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.nca.idl.NcaDao.java

package com.haiziwang.commodity.cpp.request;


import com.paipai.netframework.kernal.NetMessage;
import com.paipai.util.io.ByteStream;

/**
 * 根据erpclassId获取父子路径 
 *
 *@date 2020-06-20 06:26:26
 *
 *@since version:0
*/
public class  GetPathByErpClassId_WGReq extends NetMessage
{
	/**
	 * 机器码，必填
	 *
	 * 版本 >= 0
	 */
	 private String machineKey = new String();

	/**
	 * 调用来源，必填
	 *
	 * 版本 >= 0
	 */
	 private String source = new String();

	/**
	 * 场景Id，必填
	 *
	 * 版本 >= 0
	 */
	 private long sceneId;

	/**
	 * 地图id，必填
	 *
	 * 版本 >= 0
	 */
	 private long mapId;

	/**
	 * erpClassId，必填
	 *
	 * 版本 >= 0
	 */
	 private String erpClassId = new String();

	/**
	 * 请求保留字
	 *
	 * 版本 >= 0
	 */
	 private String inReserve = new String();


	public int serialize(ByteStream bs) throws Exception
	{
		bs.pushString(machineKey);
		bs.pushString(source);
		bs.pushUInt(sceneId);
		bs.pushUInt(mapId);
		bs.pushString(erpClassId);
		bs.pushString(inReserve);
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{
		machineKey = bs.popString();
		source = bs.popString();
		sceneId = bs.popUInt();
		mapId = bs.popUInt();
		erpClassId = bs.popString();
		inReserve = bs.popString();
		return bs.getReadLength();
	}

	public long getCmdId()
	{
		return 0xA0011840L;
	}


	/**
	 * 获取机器码，必填
	 * 
	 * 此字段的版本 >= 0
	 * @return machineKey value 类型为:String
	 * 
	 */
	public String getMachineKey()
	{
		return machineKey;
	}


	/**
	 * 设置机器码，必填
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setMachineKey(String value)
	{
		this.machineKey = value;
	}


	/**
	 * 获取调用来源，必填
	 * 
	 * 此字段的版本 >= 0
	 * @return source value 类型为:String
	 * 
	 */
	public String getSource()
	{
		return source;
	}


	/**
	 * 设置调用来源，必填
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setSource(String value)
	{
		this.source = value;
	}


	/**
	 * 获取场景Id，必填
	 * 
	 * 此字段的版本 >= 0
	 * @return sceneId value 类型为:long
	 * 
	 */
	public long getSceneId()
	{
		return sceneId;
	}


	/**
	 * 设置场景Id，必填
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setSceneId(long value)
	{
		this.sceneId = value;
	}


	/**
	 * 获取地图id，必填
	 * 
	 * 此字段的版本 >= 0
	 * @return mapId value 类型为:long
	 * 
	 */
	public long getMapId()
	{
		return mapId;
	}


	/**
	 * 设置地图id，必填
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setMapId(long value)
	{
		this.mapId = value;
	}


	/**
	 * 获取erpClassId，必填
	 * 
	 * 此字段的版本 >= 0
	 * @return erpClassId value 类型为:String
	 * 
	 */
	public String getErpClassId()
	{
		return erpClassId;
	}


	/**
	 * 设置erpClassId，必填
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setErpClassId(String value)
	{
		this.erpClassId = value;
	}


	/**
	 * 获取请求保留字
	 * 
	 * 此字段的版本 >= 0
	 * @return inReserve value 类型为:String
	 * 
	 */
	public String getInReserve()
	{
		return inReserve;
	}


	/**
	 * 设置请求保留字
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setInReserve(String value)
	{
		this.inReserve = value;
	}


	protected int getClassSize()
	{
		return  getSize() - 4;
	}

	
	public int getSize()
	{
		int length = 0;
		try{
				length = 0;  //size_of(GetPathByErpClassId_WGReq)
				length += ByteStream.getObjectSize(machineKey, null);  //计算字段machineKey的长度 size_of(String)
				length += ByteStream.getObjectSize(source, null);  //计算字段source的长度 size_of(String)
				length += 4;  //计算字段sceneId的长度 size_of(uint32_t)
				length += 4;  //计算字段mapId的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(erpClassId, null);  //计算字段erpClassId的长度 size_of(String)
				length += ByteStream.getObjectSize(inReserve, null);  //计算字段inReserve的长度 size_of(String)
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}
	public int getSize(String encoding)
	{
		int length = 0;
		try{
				length = 0;  //size_of(GetPathByErpClassId_WGReq)
				length += ByteStream.getObjectSize(machineKey, encoding);  //计算字段machineKey的长度 size_of(String)
				length += ByteStream.getObjectSize(source, encoding);  //计算字段source的长度 size_of(String)
				length += 4;  //计算字段sceneId的长度 size_of(uint32_t)
				length += 4;  //计算字段mapId的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(erpClassId, encoding);  //计算字段erpClassId的长度 size_of(String)
				length += ByteStream.getObjectSize(inReserve, encoding);  //计算字段inReserve的长度 size_of(String)
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}

	/**
	 *下面是生成toString()方法
	 此方法用于调试时打开*
	 *如果要打开此方法，请加入commons-lang-2.4.jar
	 *并导入 import org.apache.commons.lang.builder.ToStringBuilder;
	 *      import org.apache.commons.lang.builder.ToStringStyle;
	 *
	 */
	//@Override
	//public String toString() {
	//	return ToStringBuilder.reflectionToString(this,ToStringStyle.SHORT_PREFIX_STYLE);
	//}
}
