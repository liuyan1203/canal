 
 
//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.category.ao.idl.CategoryBrandAo.java

package com.haiziwang.commodity.cpp.request;


import com.paipai.netframework.kernal.NetMessage;
import com.paipai.util.io.ByteStream;

/**
 *
 *
 *@date 2016-11-16 09:57:43
 *
 *@since version:1
*/
public class GetBrandListReq extends NetMessage
{
	/**
	 * 机器码 
	 *
	 * 版本 >= 0
	 */
	 private String machineKey = new String();

	/**
	 * 来源,必填
	 *
	 * 版本 >= 0
	 */
	 private String source = new String();

	/**
	 * 请求保留字
	 *
	 * 版本 >= 0
	 */
	 private String inReserve = new String();

	/**
	 * 查询条件
	 *
	 * 版本 >= 0
	 */
	 private BrandFilter filter = new BrandFilter();


	public int serialize(ByteStream bs) throws Exception
	{
		bs.pushString(machineKey);
		bs.pushString(source);
		bs.pushString(inReserve);
		bs.pushObject(filter);
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{
		machineKey = bs.popString();
		source = bs.popString();
		inReserve = bs.popString();
		filter = (BrandFilter)bs.popObject(BrandFilter.class);
		return bs.getReadLength();
	}

	public long getCmdId()
	{
		return 0xA0161802L;
	}


	/**
	 * 获取机器码 
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
	 * 设置机器码 
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
	 * 获取来源,必填
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
	 * 设置来源,必填
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


	/**
	 * 获取查询条件
	 * 
	 * 此字段的版本 >= 0
	 * @return filter value 类型为:BrandFilter
	 * 
	 */
	public BrandFilter getFilter()
	{
		return filter;
	}


	/**
	 * 设置查询条件
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:BrandFilter
	 * 
	 */
	public void setFilter(BrandFilter value)
	{
		if (value != null) {
				this.filter = value;
		}else{
				this.filter = new BrandFilter();
		}
	}


	protected int getClassSize()
	{
		return  getSize() - 4;
	}

	
	public int getSize()
	{
		int length = 0;
		try{
				length = 0;  //size_of(GetBrandListReq)
				length += ByteStream.getObjectSize(machineKey, null);  //计算字段machineKey的长度 size_of(String)
				length += ByteStream.getObjectSize(source, null);  //计算字段source的长度 size_of(String)
				length += ByteStream.getObjectSize(inReserve, null);  //计算字段inReserve的长度 size_of(String)
				length += ByteStream.getObjectSize(filter, null);  //计算字段filter的长度 size_of(BrandFilter)
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}
	public int getSize(String encoding)
	{
		int length = 0;
		try{
				length = 0;  //size_of(GetBrandListReq)
				length += ByteStream.getObjectSize(machineKey, encoding);  //计算字段machineKey的长度 size_of(String)
				length += ByteStream.getObjectSize(source, encoding);  //计算字段source的长度 size_of(String)
				length += ByteStream.getObjectSize(inReserve, encoding);  //计算字段inReserve的长度 size_of(String)
				length += ByteStream.getObjectSize(filter, encoding);  //计算字段filter的长度 size_of(BrandFilter)
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
