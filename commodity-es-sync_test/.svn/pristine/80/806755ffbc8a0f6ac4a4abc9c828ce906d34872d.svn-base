 
 
//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.category.ao.idl.CategoryBrandAo.java

package com.haiziwang.commodity.cpp.response;


import com.paipai.netframework.kernal.NetMessage;
import com.paipai.util.io.ByteStream;

/**
 *
 *
 *@date 2016-11-16 09:57:43
 *
 *@since version:1
*/
public class  GetBrandByIdResp extends NetMessage
{
	/**
	 * 返回品牌结果(如果不存在,不设置任何字段)
	 *
	 * 版本 >= 0
	 */
	 private Brand brand = new Brand();

	/**
	 * 错误信息
	 *
	 * 版本 >= 0
	 */
	 private String errmsg = new String();

	/**
	 * 返回保留字 
	 *
	 * 版本 >= 0
	 */
	 private String outReserve = new String();


	public int serialize(ByteStream bs) throws Exception
	{

		bs.pushUInt(result);
		bs.pushObject(brand);
		bs.pushString(errmsg);
		bs.pushString(outReserve);
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{

		result = bs.popUInt();
		brand = (Brand)bs.popObject(Brand.class);
		errmsg = bs.popString();
		outReserve = bs.popString();
		return bs.getReadLength();
	}

	public long getCmdId()
	{
		return 0xA0168801L;
	}


	/**
	 * 获取返回品牌结果(如果不存在,不设置任何字段)
	 * 
	 * 此字段的版本 >= 0
	 * @return brand value 类型为:Brand
	 * 
	 */
	public Brand getBrand()
	{
		return brand;
	}


	/**
	 * 设置返回品牌结果(如果不存在,不设置任何字段)
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Brand
	 * 
	 */
	public void setBrand(Brand value)
	{
		if (value != null) {
				this.brand = value;
		}else{
				this.brand = new Brand();
		}
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
	 * 获取返回保留字 
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
	 * 设置返回保留字 
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
				length = 4;  //size_of(GetBrandByIdResp)
				length += ByteStream.getObjectSize(brand, null);  //计算字段brand的长度 size_of(Brand)
				length += ByteStream.getObjectSize(errmsg, null);  //计算字段errmsg的长度 size_of(String)
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
				length = 0;  //size_of(GetBrandByIdResp)
				length += ByteStream.getObjectSize(brand, encoding);  //计算字段brand的长度 size_of(Brand)
				length += ByteStream.getObjectSize(errmsg, encoding);  //计算字段errmsg的长度 size_of(String)
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
