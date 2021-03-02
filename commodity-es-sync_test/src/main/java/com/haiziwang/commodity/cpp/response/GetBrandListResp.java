 
 
//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.category.ao.idl.CategoryBrandAo.java

package com.haiziwang.commodity.cpp.response;


import com.paipai.netframework.kernal.NetMessage;
import com.paipai.util.io.ByteStream;

import java.util.Vector;

/**
 *
 *
 *@date 2016-11-16 09:57:43
 *
 *@since version:1
*/
public class GetBrandListResp extends NetMessage
{
	/**
	 * 满足条件的总数
	 *
	 * 版本 >= 0
	 */
	 private long totalSize;

	/**
	 * 获取的本页数据(列表有可能为空)
	 *
	 * 版本 >= 0
	 */
	 private Vector<Brand> brandList = new Vector<Brand>();

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
		bs.pushUInt(totalSize);
		bs.pushObject(brandList);
		bs.pushString(errmsg);
		bs.pushString(outReserve);
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{

		result = bs.popUInt();
		totalSize = bs.popUInt();
		brandList = (Vector<Brand>)bs.popVector(Brand.class);
		errmsg = bs.popString();
		outReserve = bs.popString();
		return bs.getReadLength();
	}

	public long getCmdId()
	{
		return 0xA0168802L;
	}


	/**
	 * 获取满足条件的总数
	 * 
	 * 此字段的版本 >= 0
	 * @return totalSize value 类型为:long
	 * 
	 */
	public long getTotalSize()
	{
		return totalSize;
	}


	/**
	 * 设置满足条件的总数
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setTotalSize(long value)
	{
		this.totalSize = value;
	}


	/**
	 * 获取获取的本页数据(列表有可能为空)
	 * 
	 * 此字段的版本 >= 0
	 * @return brandList value 类型为:Vector<Brand>
	 * 
	 */
	public Vector<Brand> getBrandList()
	{
		return brandList;
	}


	/**
	 * 设置获取的本页数据(列表有可能为空)
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Vector<Brand>
	 * 
	 */
	public void setBrandList(Vector<Brand> value)
	{
		if (value != null) {
				this.brandList = value;
		}else{
				this.brandList = new Vector<Brand>();
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
				length = 4;  //size_of(GetBrandListResp)
				length += 4;  //计算字段totalSize的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(brandList, null);  //计算字段brandList的长度 size_of(Vector)
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
				length = 0;  //size_of(GetBrandListResp)
				length += 4;  //计算字段totalSize的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(brandList, encoding);  //计算字段brandList的长度 size_of(Vector)
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
