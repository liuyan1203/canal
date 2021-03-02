 
 
//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.nca.idl.NcaDao.java

package com.haiziwang.commodity.cpp.response;


import com.paipai.lang.uint32_t;
import com.paipai.netframework.kernal.NetMessage;
import com.paipai.util.io.ByteStream;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过指定品牌id获取品牌信息 
 *
 *@date 2020-04-23 11:22:38
 *
 *@since version:0
*/
public class GetBrandsByIdResp extends NetMessage
{
	/**
	 * 错误信息
	 *
	 * 版本 >= 0
	 */
	 private String errmsg = new String();

	/**
	 * 输出属性串
	 *
	 * 版本 >= 0
	 */
	 private Map<uint32_t, Brand> Brands = new HashMap<uint32_t, Brand>();

	/**
	 * 输出保留字
	 *
	 * 版本 >= 0
	 */
	 private String outReserve = new String();


	public int serialize(ByteStream bs) throws Exception
	{

		bs.pushUInt(result);
		bs.pushString(errmsg);
		bs.pushObject(Brands);
		bs.pushString(outReserve);
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{

		result = bs.popUInt();
		errmsg = bs.popString();
		Brands = (Map<uint32_t, Brand>)bs.popMap(uint32_t.class, Brand.class);
		outReserve = bs.popString();
		return bs.getReadLength();
	}

	public long getCmdId()
	{
		return 0xA001883EL;
	}


	/**
	 * 获取错误信息
	 * 
	 * 此字段的版本 >= 0
	 * @return errmsg value 类型为:String
	 * 
	 */
	public String getErrmsg()
	{
		return errmsg;
	}


	/**
	 * 设置错误信息
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setErrmsg(String value)
	{
		this.errmsg = value;
	}


	/**
	 * 获取输出属性串
	 * 
	 * 此字段的版本 >= 0
	 * @return Brands value 类型为:Map<uint32_t,Brand>
	 * 
	 */
	public Map<uint32_t, Brand> getBrands()
	{
		return Brands;
	}


	/**
	 * 设置输出属性串
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Map<uint32_t,Brand>
	 * 
	 */
	public void setBrands(Map<uint32_t, Brand> value)
	{
		if (value != null) {
				this.Brands = value;
		}else{
				this.Brands = new HashMap<uint32_t, Brand>();
		}
	}


	/**
	 * 获取输出保留字
	 * 
	 * 此字段的版本 >= 0
	 * @return outReserve value 类型为:String
	 * 
	 */
	public String getOutReserve()
	{
		return outReserve;
	}


	/**
	 * 设置输出保留字
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setOutReserve(String value)
	{
		this.outReserve = value;
	}


	protected int getClassSize()
	{
		return  getSize() - 4;
	}

	
	public int getSize()
	{
		int length = 4;
		try{
				length = 4;  //size_of(GetBrandsByIdResp)
				length += ByteStream.getObjectSize(errmsg, null);  //计算字段errmsg的长度 size_of(String)
				length += ByteStream.getObjectSize(Brands, null);  //计算字段Brands的长度 size_of(Map)
				length += ByteStream.getObjectSize(outReserve, null);  //计算字段outReserve的长度 size_of(String)
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}
	public int getSize(String encoding)
	{
		int length = 0;
		try{
				length = 0;  //size_of(GetBrandsByIdResp)
				length += ByteStream.getObjectSize(errmsg, encoding);  //计算字段errmsg的长度 size_of(String)
				length += ByteStream.getObjectSize(Brands, encoding);  //计算字段Brands的长度 size_of(Map)
				length += ByteStream.getObjectSize(outReserve, encoding);  //计算字段outReserve的长度 size_of(String)
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
