//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.category.po.idl.CategoryBrandPo.java

package com.haiziwang.commodity.cpp.request;


import com.paipai.lang.uint32_t;
import com.paipai.util.io.ByteStream;
import com.paipai.util.io.ICanSerializeObjectExt4Encoding;

import java.util.Vector;

/**
 *品牌查询条件(分页查询)
 *
 *@date 2017-02-16 03:49:34
 *
 *@since version:0
*/
public class BrandFilter implements ICanSerializeObjectExt4Encoding
{
	/**
	 * PO版本号 
	 *
	 * 版本 >= 0
	 */
	 private long version = 20161012;

	/**
	 * 版本 >= 0
	 */
	 private short version_u;

	/**
	 * 品牌Id列表
	 *
	 * 版本 >= 0
	 */
	 private Vector<uint32_t> brandIdList = new Vector<uint32_t>();

	/**
	 * 版本 >= 0
	 */
	 private short brandIdList_u;

	/**
	 * 品牌名称(中文)
	 *
	 * 版本 >= 0
	 */
	 private String brandNameCn = new String();

	/**
	 * 版本 >= 0
	 */
	 private short brandNameCn_u;

	/**
	 * 品牌名称(中文)查询方式(默认精确查询): 0:精确 1:模糊
	 *
	 * 版本 >= 0
	 */
	 private long brandNameCnFuzzy;

	/**
	 * 版本 >= 0
	 */
	 private short brandNameCnFuzzy_u;

	/**
	 * 品牌名称(英文)
	 *
	 * 版本 >= 0
	 */
	 private String brandNameEn = new String();

	/**
	 * 版本 >= 0
	 */
	 private short brandNameEn_u;

	/**
	 * 品牌名称(英文)查询方式(默认精确查询):  0:精确 1:模糊
	 *
	 * 版本 >= 0
	 */
	 private long brandNameEnFuzzy;

	/**
	 * 版本 >= 0
	 */
	 private short brandNameEnFuzzy_u;

	/**
	 * 排序方式(默认方式1)   1:品牌id升序, 2:品牌id降序 3:品牌中文名称升序 4:品牌中文名称降序 5:品牌英文名称升序 6:品牌英文名称降序
	 *
	 * 版本 >= 0
	 */
	 private long sortType;

	/**
	 * 版本 >= 0
	 */
	 private short sortType_u;

	/**
	 * 分页大小,取值范围[1,2000]
	 *
	 * 版本 >= 0
	 */
	 private long pageSize;

	/**
	 * 版本 >= 0
	 */
	 private short pageSize_u;

	/**
	 * 分页数据,从0开始编号
	 *
	 * 版本 >= 0
	 */
	 private long index;

	/**
	 * 版本 >= 0
	 */
	 private short index_u;

	/**
	 * 品牌名称
	 *
	 * 版本 >= 20140303
	 */
	 private String brandName = new String();

	/**
	 * 品牌名称
	 *
	 * 版本 >= 20140303
	 */
	 private short brandName_u;

	/**
	 * 品牌名称查询方式(默认精确查询): 0:精确 1:模糊
	 *
	 * 版本 >= 20140303
	 */
	 private long brandNameFuzzy;

	/**
	 * 品牌名称查询方式(默认精确查询): 0:精确 1:模糊
	 *
	 * 版本 >= 20140303
	 */
	 private short brandNameFuzzy_u;

	/**
	 * ERP品牌Id
	 *
	 * 版本 >= 20161012
	 */
	 private String erpBrandId = new String();

	/**
	 * ERP品牌Id
	 *
	 * 版本 >= 20161012
	 */
	 private short erpBrandId_u;

	/**
	 * ERP品牌名称
	 *
	 * 版本 >= 20161012
	 */
	 private String erpBrandName = new String();

	/**
	 * ERP品牌名称
	 *
	 * 版本 >= 20161012
	 */
	 private short erpBrandName_u;

	/**
	 * ERP品牌名称(默认精确查询): 0:精确 1:模糊
	 *
	 * 版本 >= 20161012
	 */
	 private long erpBrandNameFuzzy;

	/**
	 * ERP品牌名称(默认精确查询): 0:精确 1:模糊
	 *
	 * 版本 >= 20161012
	 */
	 private short erpBrandNameFuzzy_u;



	public int serialize(ByteStream bs) throws Exception
	{
		bs.pushUInt(getSize(bs.getDecodeCharset()) - 4);
		bs.pushUInt(version);
		bs.pushUByte(version_u);
		bs.pushObject(brandIdList);
		bs.pushUByte(brandIdList_u);
		bs.pushString(brandNameCn);
		bs.pushUByte(brandNameCn_u);
		bs.pushUInt(brandNameCnFuzzy);
		bs.pushUByte(brandNameCnFuzzy_u);
		bs.pushString(brandNameEn);
		bs.pushUByte(brandNameEn_u);
		bs.pushUInt(brandNameEnFuzzy);
		bs.pushUByte(brandNameEnFuzzy_u);
		bs.pushUInt(sortType);
		bs.pushUByte(sortType_u);
		bs.pushUInt(pageSize);
		bs.pushUByte(pageSize_u);
		bs.pushUInt(index);
		bs.pushUByte(index_u);
		if(  this.version >= 20140303 ){
				bs.pushString(brandName);
		}
		if(  this.version >= 20140303 ){
				bs.pushUByte(brandName_u);
		}
		if(  this.version >= 20140303 ){
				bs.pushUInt(brandNameFuzzy);
		}
		if(  this.version >= 20140303 ){
				bs.pushUByte(brandNameFuzzy_u);
		}
		if(  this.version >= 20161012 ){
				bs.pushString(erpBrandId);
		}
		if(  this.version >= 20161012 ){
				bs.pushUByte(erpBrandId_u);
		}
		if(  this.version >= 20161012 ){
				bs.pushString(erpBrandName);
		}
		if(  this.version >= 20161012 ){
				bs.pushUByte(erpBrandName_u);
		}
		if(  this.version >= 20161012 ){
				bs.pushUInt(erpBrandNameFuzzy);
		}
		if(  this.version >= 20161012 ){
				bs.pushUByte(erpBrandNameFuzzy_u);
		}
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{
		long size = bs.popUInt();
		int startPosPop = bs.getReadLength();
		if (size == 0)
				return 0;
		version = bs.popUInt();
		version_u = bs.popUByte();
		brandIdList = (Vector<uint32_t>)bs.popVector(uint32_t.class);
		brandIdList_u = bs.popUByte();
		brandNameCn = bs.popString();
		brandNameCn_u = bs.popUByte();
		brandNameCnFuzzy = bs.popUInt();
		brandNameCnFuzzy_u = bs.popUByte();
		brandNameEn = bs.popString();
		brandNameEn_u = bs.popUByte();
		brandNameEnFuzzy = bs.popUInt();
		brandNameEnFuzzy_u = bs.popUByte();
		sortType = bs.popUInt();
		sortType_u = bs.popUByte();
		pageSize = bs.popUInt();
		pageSize_u = bs.popUByte();
		index = bs.popUInt();
		index_u = bs.popUByte();
		if(  this.version >= 20140303 ){
				brandName = bs.popString();
		}
		if(  this.version >= 20140303 ){
				brandName_u = bs.popUByte();
		}
		if(  this.version >= 20140303 ){
				brandNameFuzzy = bs.popUInt();
		}
		if(  this.version >= 20140303 ){
				brandNameFuzzy_u = bs.popUByte();
		}
		if(  this.version >= 20161012 ){
				erpBrandId = bs.popString();
		}
		if(  this.version >= 20161012 ){
				erpBrandId_u = bs.popUByte();
		}
		if(  this.version >= 20161012 ){
				erpBrandName = bs.popString();
		}
		if(  this.version >= 20161012 ){
				erpBrandName_u = bs.popUByte();
		}
		if(  this.version >= 20161012 ){
				erpBrandNameFuzzy = bs.popUInt();
		}
		if(  this.version >= 20161012 ){
				erpBrandNameFuzzy_u = bs.popUByte();
		}

		/**********************为了支持多个版本的客户端************************/
		int needPopBytes = (int)size - (bs.getReadLength() - startPosPop);
		for(int i = 0;i< needPopBytes; i++)
				bs.popByte();
		/**********************为了支持多个版本的客户端************************/

		return bs.getReadLength();
	} 


	/**
	 * 获取PO版本号 
	 * 
	 * 此字段的版本 >= 0
	 * @return version value 类型为:long
	 * 
	 */
	public long getVersion()
	{
		return version;
	}


	/**
	 * 设置PO版本号 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setVersion(long value)
	{
		this.version = value;
		this.version_u = 1;
	}

	public boolean issetVersion()
	{
		return this.version_u != 0;
	}
	/**
	 * 获取
	 * 
	 * 此字段的版本 >= 0
	 * @return version_u value 类型为:short
	 * 
	 */
	public short getVersion_u()
	{
		return version_u;
	}


	/**
	 * 设置
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	public void setVersion_u(short value)
	{
		this.version_u = value;
	}


	/**
	 * 获取品牌Id列表
	 * 
	 * 此字段的版本 >= 0
	 * @return brandIdList value 类型为:Vector<uint32_t>
	 * 
	 */
	public Vector<uint32_t> getBrandIdList()
	{
		return brandIdList;
	}


	/**
	 * 设置品牌Id列表
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:Vector<uint32_t>
	 * 
	 */
	public void setBrandIdList(Vector<uint32_t> value)
	{
		if (value != null) {
				this.brandIdList = value;
				this.brandIdList_u = 1;
		}
	}

	public boolean issetBrandIdList()
	{
		return this.brandIdList_u != 0;
	}
	/**
	 * 获取
	 * 
	 * 此字段的版本 >= 0
	 * @return brandIdList_u value 类型为:short
	 * 
	 */
	public short getBrandIdList_u()
	{
		return brandIdList_u;
	}


	/**
	 * 设置
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	public void setBrandIdList_u(short value)
	{
		this.brandIdList_u = value;
	}


	/**
	 * 获取品牌名称(中文)
	 * 
	 * 此字段的版本 >= 0
	 * @return brandNameCn value 类型为:String
	 * 
	 */
	public String getBrandNameCn()
	{
		return brandNameCn;
	}


	/**
	 * 设置品牌名称(中文)
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setBrandNameCn(String value)
	{
		this.brandNameCn = value;
		this.brandNameCn_u = 1;
	}

	public boolean issetBrandNameCn()
	{
		return this.brandNameCn_u != 0;
	}
	/**
	 * 获取
	 * 
	 * 此字段的版本 >= 0
	 * @return brandNameCn_u value 类型为:short
	 * 
	 */
	public short getBrandNameCn_u()
	{
		return brandNameCn_u;
	}


	/**
	 * 设置
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	public void setBrandNameCn_u(short value)
	{
		this.brandNameCn_u = value;
	}


	/**
	 * 获取品牌名称(中文)查询方式(默认精确查询): 0:精确 1:模糊
	 * 
	 * 此字段的版本 >= 0
	 * @return brandNameCnFuzzy value 类型为:long
	 * 
	 */
	public long getBrandNameCnFuzzy()
	{
		return brandNameCnFuzzy;
	}


	/**
	 * 设置品牌名称(中文)查询方式(默认精确查询): 0:精确 1:模糊
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setBrandNameCnFuzzy(long value)
	{
		this.brandNameCnFuzzy = value;
		this.brandNameCnFuzzy_u = 1;
	}

	public boolean issetBrandNameCnFuzzy()
	{
		return this.brandNameCnFuzzy_u != 0;
	}
	/**
	 * 获取
	 * 
	 * 此字段的版本 >= 0
	 * @return brandNameCnFuzzy_u value 类型为:short
	 * 
	 */
	public short getBrandNameCnFuzzy_u()
	{
		return brandNameCnFuzzy_u;
	}


	/**
	 * 设置
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	public void setBrandNameCnFuzzy_u(short value)
	{
		this.brandNameCnFuzzy_u = value;
	}


	/**
	 * 获取品牌名称(英文)
	 * 
	 * 此字段的版本 >= 0
	 * @return brandNameEn value 类型为:String
	 * 
	 */
	public String getBrandNameEn()
	{
		return brandNameEn;
	}


	/**
	 * 设置品牌名称(英文)
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setBrandNameEn(String value)
	{
		this.brandNameEn = value;
		this.brandNameEn_u = 1;
	}

	public boolean issetBrandNameEn()
	{
		return this.brandNameEn_u != 0;
	}
	/**
	 * 获取
	 * 
	 * 此字段的版本 >= 0
	 * @return brandNameEn_u value 类型为:short
	 * 
	 */
	public short getBrandNameEn_u()
	{
		return brandNameEn_u;
	}


	/**
	 * 设置
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	public void setBrandNameEn_u(short value)
	{
		this.brandNameEn_u = value;
	}


	/**
	 * 获取品牌名称(英文)查询方式(默认精确查询):  0:精确 1:模糊
	 * 
	 * 此字段的版本 >= 0
	 * @return brandNameEnFuzzy value 类型为:long
	 * 
	 */
	public long getBrandNameEnFuzzy()
	{
		return brandNameEnFuzzy;
	}


	/**
	 * 设置品牌名称(英文)查询方式(默认精确查询):  0:精确 1:模糊
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setBrandNameEnFuzzy(long value)
	{
		this.brandNameEnFuzzy = value;
		this.brandNameEnFuzzy_u = 1;
	}

	public boolean issetBrandNameEnFuzzy()
	{
		return this.brandNameEnFuzzy_u != 0;
	}
	/**
	 * 获取
	 * 
	 * 此字段的版本 >= 0
	 * @return brandNameEnFuzzy_u value 类型为:short
	 * 
	 */
	public short getBrandNameEnFuzzy_u()
	{
		return brandNameEnFuzzy_u;
	}


	/**
	 * 设置
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	public void setBrandNameEnFuzzy_u(short value)
	{
		this.brandNameEnFuzzy_u = value;
	}


	/**
	 * 获取排序方式(默认方式1)   1:品牌id升序, 2:品牌id降序 3:品牌中文名称升序 4:品牌中文名称降序 5:品牌英文名称升序 6:品牌英文名称降序
	 * 
	 * 此字段的版本 >= 0
	 * @return sortType value 类型为:long
	 * 
	 */
	public long getSortType()
	{
		return sortType;
	}


	/**
	 * 设置排序方式(默认方式1)   1:品牌id升序, 2:品牌id降序 3:品牌中文名称升序 4:品牌中文名称降序 5:品牌英文名称升序 6:品牌英文名称降序
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setSortType(long value)
	{
		this.sortType = value;
		this.sortType_u = 1;
	}

	public boolean issetSortType()
	{
		return this.sortType_u != 0;
	}
	/**
	 * 获取
	 * 
	 * 此字段的版本 >= 0
	 * @return sortType_u value 类型为:short
	 * 
	 */
	public short getSortType_u()
	{
		return sortType_u;
	}


	/**
	 * 设置
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	public void setSortType_u(short value)
	{
		this.sortType_u = value;
	}


	/**
	 * 获取分页大小,取值范围[1,2000]
	 * 
	 * 此字段的版本 >= 0
	 * @return pageSize value 类型为:long
	 * 
	 */
	public long getPageSize()
	{
		return pageSize;
	}


	/**
	 * 设置分页大小,取值范围[1,2000]
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setPageSize(long value)
	{
		this.pageSize = value;
		this.pageSize_u = 1;
	}

	public boolean issetPageSize()
	{
		return this.pageSize_u != 0;
	}
	/**
	 * 获取
	 * 
	 * 此字段的版本 >= 0
	 * @return pageSize_u value 类型为:short
	 * 
	 */
	public short getPageSize_u()
	{
		return pageSize_u;
	}


	/**
	 * 设置
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	public void setPageSize_u(short value)
	{
		this.pageSize_u = value;
	}


	/**
	 * 获取分页数据,从0开始编号
	 * 
	 * 此字段的版本 >= 0
	 * @return index value 类型为:long
	 * 
	 */
	public long getIndex()
	{
		return index;
	}


	/**
	 * 设置分页数据,从0开始编号
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setIndex(long value)
	{
		this.index = value;
		this.index_u = 1;
	}

	public boolean issetIndex()
	{
		return this.index_u != 0;
	}
	/**
	 * 获取
	 * 
	 * 此字段的版本 >= 0
	 * @return index_u value 类型为:short
	 * 
	 */
	public short getIndex_u()
	{
		return index_u;
	}


	/**
	 * 设置
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	public void setIndex_u(short value)
	{
		this.index_u = value;
	}


	/**
	 * 获取品牌名称
	 * 
	 * 此字段的版本 >= 20140303
	 * @return brandName value 类型为:String
	 * 
	 */
	public String getBrandName()
	{
		return brandName;
	}


	/**
	 * 设置品牌名称
	 * 
	 * 此字段的版本 >= 20140303
	 * @param  value 类型为:String
	 * 
	 */
	public void setBrandName(String value)
	{
		this.brandName = value;
		this.brandName_u = 1;
	}

	public boolean issetBrandName()
	{
		return this.brandName_u != 0;
	}
	/**
	 * 获取品牌名称
	 * 
	 * 此字段的版本 >= 20140303
	 * @return brandName_u value 类型为:short
	 * 
	 */
	public short getBrandName_u()
	{
		return brandName_u;
	}


	/**
	 * 设置品牌名称
	 * 
	 * 此字段的版本 >= 20140303
	 * @param  value 类型为:short
	 * 
	 */
	public void setBrandName_u(short value)
	{
		this.brandName_u = value;
	}


	/**
	 * 获取品牌名称查询方式(默认精确查询): 0:精确 1:模糊
	 * 
	 * 此字段的版本 >= 20140303
	 * @return brandNameFuzzy value 类型为:long
	 * 
	 */
	public long getBrandNameFuzzy()
	{
		return brandNameFuzzy;
	}


	/**
	 * 设置品牌名称查询方式(默认精确查询): 0:精确 1:模糊
	 * 
	 * 此字段的版本 >= 20140303
	 * @param  value 类型为:long
	 * 
	 */
	public void setBrandNameFuzzy(long value)
	{
		this.brandNameFuzzy = value;
		this.brandNameFuzzy_u = 1;
	}

	public boolean issetBrandNameFuzzy()
	{
		return this.brandNameFuzzy_u != 0;
	}
	/**
	 * 获取品牌名称查询方式(默认精确查询): 0:精确 1:模糊
	 * 
	 * 此字段的版本 >= 20140303
	 * @return brandNameFuzzy_u value 类型为:short
	 * 
	 */
	public short getBrandNameFuzzy_u()
	{
		return brandNameFuzzy_u;
	}


	/**
	 * 设置品牌名称查询方式(默认精确查询): 0:精确 1:模糊
	 * 
	 * 此字段的版本 >= 20140303
	 * @param  value 类型为:short
	 * 
	 */
	public void setBrandNameFuzzy_u(short value)
	{
		this.brandNameFuzzy_u = value;
	}


	/**
	 * 获取ERP品牌Id
	 * 
	 * 此字段的版本 >= 20161012
	 * @return erpBrandId value 类型为:String
	 * 
	 */
	public String getErpBrandId()
	{
		return erpBrandId;
	}


	/**
	 * 设置ERP品牌Id
	 * 
	 * 此字段的版本 >= 20161012
	 * @param  value 类型为:String
	 * 
	 */
	public void setErpBrandId(String value)
	{
		this.erpBrandId = value;
		this.erpBrandId_u = 1;
	}

	public boolean issetErpBrandId()
	{
		return this.erpBrandId_u != 0;
	}
	/**
	 * 获取ERP品牌Id
	 * 
	 * 此字段的版本 >= 20161012
	 * @return erpBrandId_u value 类型为:short
	 * 
	 */
	public short getErpBrandId_u()
	{
		return erpBrandId_u;
	}


	/**
	 * 设置ERP品牌Id
	 * 
	 * 此字段的版本 >= 20161012
	 * @param  value 类型为:short
	 * 
	 */
	public void setErpBrandId_u(short value)
	{
		this.erpBrandId_u = value;
	}


	/**
	 * 获取ERP品牌名称
	 * 
	 * 此字段的版本 >= 20161012
	 * @return erpBrandName value 类型为:String
	 * 
	 */
	public String getErpBrandName()
	{
		return erpBrandName;
	}


	/**
	 * 设置ERP品牌名称
	 * 
	 * 此字段的版本 >= 20161012
	 * @param  value 类型为:String
	 * 
	 */
	public void setErpBrandName(String value)
	{
		this.erpBrandName = value;
		this.erpBrandName_u = 1;
	}

	public boolean issetErpBrandName()
	{
		return this.erpBrandName_u != 0;
	}
	/**
	 * 获取ERP品牌名称
	 * 
	 * 此字段的版本 >= 20161012
	 * @return erpBrandName_u value 类型为:short
	 * 
	 */
	public short getErpBrandName_u()
	{
		return erpBrandName_u;
	}


	/**
	 * 设置ERP品牌名称
	 * 
	 * 此字段的版本 >= 20161012
	 * @param  value 类型为:short
	 * 
	 */
	public void setErpBrandName_u(short value)
	{
		this.erpBrandName_u = value;
	}


	/**
	 * 获取ERP品牌名称(默认精确查询): 0:精确 1:模糊
	 * 
	 * 此字段的版本 >= 20161012
	 * @return erpBrandNameFuzzy value 类型为:long
	 * 
	 */
	public long getErpBrandNameFuzzy()
	{
		return erpBrandNameFuzzy;
	}


	/**
	 * 设置ERP品牌名称(默认精确查询): 0:精确 1:模糊
	 * 
	 * 此字段的版本 >= 20161012
	 * @param  value 类型为:long
	 * 
	 */
	public void setErpBrandNameFuzzy(long value)
	{
		this.erpBrandNameFuzzy = value;
		this.erpBrandNameFuzzy_u = 1;
	}

	public boolean issetErpBrandNameFuzzy()
	{
		return this.erpBrandNameFuzzy_u != 0;
	}
	/**
	 * 获取ERP品牌名称(默认精确查询): 0:精确 1:模糊
	 * 
	 * 此字段的版本 >= 20161012
	 * @return erpBrandNameFuzzy_u value 类型为:short
	 * 
	 */
	public short getErpBrandNameFuzzy_u()
	{
		return erpBrandNameFuzzy_u;
	}


	/**
	 * 设置ERP品牌名称(默认精确查询): 0:精确 1:模糊
	 * 
	 * 此字段的版本 >= 20161012
	 * @param  value 类型为:short
	 * 
	 */
	public void setErpBrandNameFuzzy_u(short value)
	{
		this.erpBrandNameFuzzy_u = value;
	}


	/**
	 *   计算类长度
	 *   用于告诉解包者，该类只放了这么长的数据
	 *  
 	 */
	protected int getClassSize()
	{
		int length = getSize() - 4;
		try{

		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}

	
	/**
	 *   计算类长度
	 *   这个是该类的实际长度，在序列化时bytestream会调用这个方法
	 *  
 	 */
	public int getSize()
	{
		int length = 4;
		try{
				length = 4;  //size_of(BrandFilter)
				length += 4;  //计算字段version的长度 size_of(uint32_t)
				length += 1;  //计算字段version_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandIdList, null);  //计算字段brandIdList的长度 size_of(Vector)
				length += 1;  //计算字段brandIdList_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandNameCn, null);  //计算字段brandNameCn的长度 size_of(String)
				length += 1;  //计算字段brandNameCn_u的长度 size_of(uint8_t)
				length += 4;  //计算字段brandNameCnFuzzy的长度 size_of(uint32_t)
				length += 1;  //计算字段brandNameCnFuzzy_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandNameEn, null);  //计算字段brandNameEn的长度 size_of(String)
				length += 1;  //计算字段brandNameEn_u的长度 size_of(uint8_t)
				length += 4;  //计算字段brandNameEnFuzzy的长度 size_of(uint32_t)
				length += 1;  //计算字段brandNameEnFuzzy_u的长度 size_of(uint8_t)
				length += 4;  //计算字段sortType的长度 size_of(uint32_t)
				length += 1;  //计算字段sortType_u的长度 size_of(uint8_t)
				length += 4;  //计算字段pageSize的长度 size_of(uint32_t)
				length += 1;  //计算字段pageSize_u的长度 size_of(uint8_t)
				length += 4;  //计算字段index的长度 size_of(uint32_t)
				length += 1;  //计算字段index_u的长度 size_of(uint8_t)
				if(  this.version >= 20140303 ){
						length += ByteStream.getObjectSize(brandName, null);  //计算字段brandName的长度 size_of(String)
				}
				if(  this.version >= 20140303 ){
						length += 1;  //计算字段brandName_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20140303 ){
						length += 4;  //计算字段brandNameFuzzy的长度 size_of(uint32_t)
				}
				if(  this.version >= 20140303 ){
						length += 1;  //计算字段brandNameFuzzy_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20161012 ){
						length += ByteStream.getObjectSize(erpBrandId, null);  //计算字段erpBrandId的长度 size_of(String)
				}
				if(  this.version >= 20161012 ){
						length += 1;  //计算字段erpBrandId_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20161012 ){
						length += ByteStream.getObjectSize(erpBrandName, null);  //计算字段erpBrandName的长度 size_of(String)
				}
				if(  this.version >= 20161012 ){
						length += 1;  //计算字段erpBrandName_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20161012 ){
						length += 4;  //计算字段erpBrandNameFuzzy的长度 size_of(uint32_t)
				}
				if(  this.version >= 20161012 ){
						length += 1;  //计算字段erpBrandNameFuzzy_u的长度 size_of(uint8_t)
				}
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}


	/**
	 *   计算类长度
	 *   这个是实现String字符集传入的方法
	 *  
 	 */
	public int getSize(String encoding)
	{
		int length = 4;
		try{
				length = 4;  //size_of(BrandFilter)
				length += 4;  //计算字段version的长度 size_of(uint32_t)
				length += 1;  //计算字段version_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandIdList, encoding);  //计算字段brandIdList的长度 size_of(Vector)
				length += 1;  //计算字段brandIdList_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandNameCn, encoding);  //计算字段brandNameCn的长度 size_of(String)
				length += 1;  //计算字段brandNameCn_u的长度 size_of(uint8_t)
				length += 4;  //计算字段brandNameCnFuzzy的长度 size_of(uint32_t)
				length += 1;  //计算字段brandNameCnFuzzy_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandNameEn, encoding);  //计算字段brandNameEn的长度 size_of(String)
				length += 1;  //计算字段brandNameEn_u的长度 size_of(uint8_t)
				length += 4;  //计算字段brandNameEnFuzzy的长度 size_of(uint32_t)
				length += 1;  //计算字段brandNameEnFuzzy_u的长度 size_of(uint8_t)
				length += 4;  //计算字段sortType的长度 size_of(uint32_t)
				length += 1;  //计算字段sortType_u的长度 size_of(uint8_t)
				length += 4;  //计算字段pageSize的长度 size_of(uint32_t)
				length += 1;  //计算字段pageSize_u的长度 size_of(uint8_t)
				length += 4;  //计算字段index的长度 size_of(uint32_t)
				length += 1;  //计算字段index_u的长度 size_of(uint8_t)
				if(  this.version >= 20140303 ){
						length += ByteStream.getObjectSize(brandName, encoding);  //计算字段brandName的长度 size_of(String)
				}
				if(  this.version >= 20140303 ){
						length += 1;  //计算字段brandName_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20140303 ){
						length += 4;  //计算字段brandNameFuzzy的长度 size_of(uint32_t)
				}
				if(  this.version >= 20140303 ){
						length += 1;  //计算字段brandNameFuzzy_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20161012 ){
						length += ByteStream.getObjectSize(erpBrandId, encoding);  //计算字段erpBrandId的长度 size_of(String)
				}
				if(  this.version >= 20161012 ){
						length += 1;  //计算字段erpBrandId_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20161012 ){
						length += ByteStream.getObjectSize(erpBrandName, encoding);  //计算字段erpBrandName的长度 size_of(String)
				}
				if(  this.version >= 20161012 ){
						length += 1;  //计算字段erpBrandName_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20161012 ){
						length += 4;  //计算字段erpBrandNameFuzzy的长度 size_of(uint32_t)
				}
				if(  this.version >= 20161012 ){
						length += 1;  //计算字段erpBrandNameFuzzy_u的长度 size_of(uint8_t)
				}
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}


/**
 ********************以下信息是每个版本的字段********************
 *
 *****以下是版本20161012所包含的字段*******
 *	long version;///<PO版本号 
 *	short version_u;
 *	Vector<uint32_t> brandIdList;///<品牌Id列表
 *	short brandIdList_u;
 *	String brandNameCn;///<品牌名称(中文)
 *	short brandNameCn_u;
 *	long brandNameCnFuzzy;///<品牌名称(中文)查询方式(默认精确查询): 0:精确 1:模糊
 *	short brandNameCnFuzzy_u;
 *	String brandNameEn;///<品牌名称(英文)
 *	short brandNameEn_u;
 *	long brandNameEnFuzzy;///<品牌名称(英文)查询方式(默认精确查询):  0:精确 1:模糊
 *	short brandNameEnFuzzy_u;
 *	long sortType;///<排序方式(默认方式1)   1:品牌id升序, 2:品牌id降序 3:品牌中文名称升序 4:品牌中文名称降序 5:品牌英文名称升序 6:品牌英文名称降序
 *	short sortType_u;
 *	long pageSize;///<分页大小,取值范围[1,2000]
 *	short pageSize_u;
 *	long index;///<分页数据,从0开始编号
 *	short index_u;
 *	String brandName;///<品牌名称
 *	short brandName_u;///<品牌名称
 *	long brandNameFuzzy;///<品牌名称查询方式(默认精确查询): 0:精确 1:模糊
 *	short brandNameFuzzy_u;///<品牌名称查询方式(默认精确查询): 0:精确 1:模糊
 *	String erpBrandId;///<ERP品牌Id
 *	short erpBrandId_u;///<ERP品牌Id
 *	String erpBrandName;///<ERP品牌名称
 *	short erpBrandName_u;///<ERP品牌名称
 *	long erpBrandNameFuzzy;///<ERP品牌名称(默认精确查询): 0:精确 1:模糊
 *	short erpBrandNameFuzzy_u;///<ERP品牌名称(默认精确查询): 0:精确 1:模糊
 *****以上是版本20161012所包含的字段*******
 *
 *****以下是版本20140303所包含的字段*******
 *	long version;///<PO版本号 
 *	short version_u;
 *	Vector<uint32_t> brandIdList;///<品牌Id列表
 *	short brandIdList_u;
 *	String brandNameCn;///<品牌名称(中文)
 *	short brandNameCn_u;
 *	long brandNameCnFuzzy;///<品牌名称(中文)查询方式(默认精确查询): 0:精确 1:模糊
 *	short brandNameCnFuzzy_u;
 *	String brandNameEn;///<品牌名称(英文)
 *	short brandNameEn_u;
 *	long brandNameEnFuzzy;///<品牌名称(英文)查询方式(默认精确查询):  0:精确 1:模糊
 *	short brandNameEnFuzzy_u;
 *	long sortType;///<排序方式(默认方式1)   1:品牌id升序, 2:品牌id降序 3:品牌中文名称升序 4:品牌中文名称降序 5:品牌英文名称升序 6:品牌英文名称降序
 *	short sortType_u;
 *	long pageSize;///<分页大小,取值范围[1,2000]
 *	short pageSize_u;
 *	long index;///<分页数据,从0开始编号
 *	short index_u;
 *	String brandName;///<品牌名称
 *	short brandName_u;///<品牌名称
 *	long brandNameFuzzy;///<品牌名称查询方式(默认精确查询): 0:精确 1:模糊
 *	short brandNameFuzzy_u;///<品牌名称查询方式(默认精确查询): 0:精确 1:模糊
 *****以上是版本20140303所包含的字段*******
 */



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
