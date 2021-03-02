 
 
//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.nca.idl.NcaDao.java

package com.haiziwang.commodity.cpp.request;


import com.paipai.netframework.kernal.NetMessage;
import com.paipai.util.io.ByteStream;

/**
 *
 *
 *@date 2020-02-22 03:15:38
 *
 *@since version:1
*/
public class  GetPubNav_ALLReq extends NetMessage
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
	 * 调用控制，业务相关
	 *
	 * 版本 >= 0
	 */
	 private APIControl APIControl = new APIControl();

	/**
	 * 导航Id，必填
	 *
	 * 版本 >= 0
	 */
	 private long NavId;

	/**
	 * 是否需要填充属性字典。叶子导航是品类，这个时候是有属性的
	 *
	 * 版本 >= 0
	 */
	 private long NeedAttrDic;

	/**
	 * 属性字典中是否只需要属性项，而不需要属性值
	 *
	 * 版本 >= 0
	 */
	 private long AttrOnly;

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
		bs.pushObject(APIControl);
		bs.pushUInt(NavId);
		bs.pushUInt(NeedAttrDic);
		bs.pushUInt(AttrOnly);
		bs.pushString(inReserve);
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{
		machineKey = bs.popString();
		source = bs.popString();
		APIControl = (APIControl) bs.popObject(APIControl.class);
		NavId = bs.popUInt();
		NeedAttrDic = bs.popUInt();
		AttrOnly = bs.popUInt();
		inReserve = bs.popString();
		return bs.getReadLength();
	}

	public long getCmdId()
	{
		return 0xA0011822L;
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
	 * 获取调用控制，业务相关
	 * 
	 * 此字段的版本 >= 0
	 * @return APIControl value 类型为:APIControl
	 * 
	 */
	public APIControl getAPIControl()
	{
		return APIControl;
	}


	/**
	 * 设置调用控制，业务相关
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:APIControl
	 * 
	 */
	public void setAPIControl(APIControl value)
	{
		if (value != null) {
				this.APIControl = value;
		}else{
				this.APIControl = new APIControl();
		}
	}


	/**
	 * 获取导航Id，必填
	 * 
	 * 此字段的版本 >= 0
	 * @return NavId value 类型为:long
	 * 
	 */
	public long getNavId()
	{
		return NavId;
	}


	/**
	 * 设置导航Id，必填
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setNavId(long value)
	{
		this.NavId = value;
	}


	/**
	 * 获取是否需要填充属性字典。叶子导航是品类，这个时候是有属性的
	 * 
	 * 此字段的版本 >= 0
	 * @return NeedAttrDic value 类型为:long
	 * 
	 */
	public long getNeedAttrDic()
	{
		return NeedAttrDic;
	}


	/**
	 * 设置是否需要填充属性字典。叶子导航是品类，这个时候是有属性的
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setNeedAttrDic(long value)
	{
		this.NeedAttrDic = value;
	}


	/**
	 * 获取属性字典中是否只需要属性项，而不需要属性值
	 * 
	 * 此字段的版本 >= 0
	 * @return AttrOnly value 类型为:long
	 * 
	 */
	public long getAttrOnly()
	{
		return AttrOnly;
	}


	/**
	 * 设置属性字典中是否只需要属性项，而不需要属性值
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setAttrOnly(long value)
	{
		this.AttrOnly = value;
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
				length = 0;  //size_of(GetPubNav_ALLReq)
				length += ByteStream.getObjectSize(machineKey, null);  //计算字段machineKey的长度 size_of(String)
				length += ByteStream.getObjectSize(source, null);  //计算字段source的长度 size_of(String)
				length += ByteStream.getObjectSize(APIControl, null);  //计算字段APIControl的长度 size_of(APIControl)
				length += 4;  //计算字段NavId的长度 size_of(uint32_t)
				length += 4;  //计算字段NeedAttrDic的长度 size_of(uint32_t)
				length += 4;  //计算字段AttrOnly的长度 size_of(uint32_t)
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
				length = 0;  //size_of(GetPubNav_ALLReq)
				length += ByteStream.getObjectSize(machineKey, encoding);  //计算字段machineKey的长度 size_of(String)
				length += ByteStream.getObjectSize(source, encoding);  //计算字段source的长度 size_of(String)
				length += ByteStream.getObjectSize(APIControl, encoding);  //计算字段APIControl的长度 size_of(APIControl)
				length += 4;  //计算字段NavId的长度 size_of(uint32_t)
				length += 4;  //计算字段NeedAttrDic的长度 size_of(uint32_t)
				length += 4;  //计算字段AttrOnly的长度 size_of(uint32_t)
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
