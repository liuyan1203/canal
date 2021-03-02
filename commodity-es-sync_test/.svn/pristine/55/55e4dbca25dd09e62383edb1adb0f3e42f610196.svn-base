 
 
//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.nca.idl.NcaDao.java

package com.haiziwang.commodity.cpp.request;


import com.paipai.lang.uint32_t;
import com.paipai.netframework.kernal.NetMessage;
import com.paipai.util.io.ByteStream;

import java.util.HashSet;
import java.util.Set;

/**
 * 通过指定品牌id获取品牌信息 
 *
 *@date 2020-04-23 11:22:38
 *
 *@since version:0
*/
public class GetBrandsByIdReq extends NetMessage
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
	 *  地图编号 
	 *
	 * 版本 >= 0
	 */
	 private Set<uint32_t> brandId = new HashSet<uint32_t>();

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
		bs.pushObject(brandId);
		bs.pushString(inReserve);
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{
		machineKey = bs.popString();
		source = bs.popString();
		sceneId = bs.popUInt();
		brandId = (Set<uint32_t>)bs.popSet(HashSet.class, uint32_t.class);
		inReserve = bs.popString();
		return bs.getReadLength();
	}

	public long getCmdId()
	{
		return 0xA001183EL;
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
	 * 获取 地图编号 
	 * 
	 * 此字段的版本 >= 0
	 * @return brandId value 类型为:Set<uint32_t>
	 * 
	 */
	public Set<uint32_t> getBrandId()
	{
		return brandId;
	}


	/**
	 * 设置 地图编号 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Set<uint32_t>
	 * 
	 */
	public void setBrandId(Set<uint32_t> value)
	{
		if (value != null) {
				this.brandId = value;
		}else{
				this.brandId = new HashSet<uint32_t>();
		}
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
				length = 0;  //size_of(GetBrandsByIdReq)
				length += ByteStream.getObjectSize(machineKey, null);  //计算字段machineKey的长度 size_of(String)
				length += ByteStream.getObjectSize(source, null);  //计算字段source的长度 size_of(String)
				length += 4;  //计算字段sceneId的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(brandId, null);  //计算字段brandId的长度 size_of(Set)
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
				length = 0;  //size_of(GetBrandsByIdReq)
				length += ByteStream.getObjectSize(machineKey, encoding);  //计算字段machineKey的长度 size_of(String)
				length += ByteStream.getObjectSize(source, encoding);  //计算字段source的长度 size_of(String)
				length += 4;  //计算字段sceneId的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(brandId, encoding);  //计算字段brandId的长度 size_of(Set)
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
