//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.category.po.idl.CategoryBrandPo.java

package com.haiziwang.commodity.cpp.response;


import com.paipai.util.io.ByteStream;
import com.paipai.util.io.ICanSerializeObjectExt4Encoding;

import java.util.BitSet;

/**
 *品牌信息
 *
 *@date 2017-02-16 03:49:34
 *
 *@since version:0
*/
public class Brand implements ICanSerializeObjectExt4Encoding
{
	/**
	 * PO版本号 
	 *
	 * 版本 >= 0
	 */
	 private long version = 20170216;

	/**
	 * 版本 >= 0
	 */
	 private short version_u;

	/**
	 * 品牌Id
	 *
	 * 版本 >= 0
	 */
	 private long brandId;

	/**
	 * 版本 >= 0
	 */
	 private short brandId_u;

	/**
	 * 品牌名称
	 *
	 * 版本 >= 0
	 */
	 private String brandName = new String();

	/**
	 * 版本 >= 0
	 */
	 private short brandName_u;

	/**
	 * 品牌名称(中文),如果没有为空
	 *
	 * 版本 >= 0
	 */
	 private String brandNameCn = new String();

	/**
	 * 版本 >= 0
	 */
	 private short brandNameCn_u;

	/**
	 * 品牌名称(英文),如果没有为空
	 *
	 * 版本 >= 0
	 */
	 private String brandNameEn = new String();

	/**
	 * 版本 >= 0
	 */
	 private short brandNameEn_u;

	/**
	 * 品牌描述信息
	 *
	 * 版本 >= 0
	 */
	 private String brandDesc = new String();

	/**
	 * 版本 >= 0
	 */
	 private short brandDesc_u;

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
	 * 品牌首字母
	 *
	 * 版本 >= 20170216
	 */
	 private String brandInitial = new String();

	/**
	 * 品牌首字母
	 *
	 * 版本 >= 20170216
	 */
	 private short brandInitial_u;

	/**
	 * logo url
	 *
	 * 版本 >= 20170216
	 */
	 private String logo = new String();

	/**
	 * logo url
	 *
	 * 版本 >= 20170216
	 */
	 private short logo_u;

	/**
	 * banner url
	 *
	 * 版本 >= 20170216
	 */
	 private String banner = new String();

	/**
	 * banner url
	 *
	 * 版本 >= 20170216
	 */
	 private short banner_u;

	/**
	 * 国家
	 *
	 * 版本 >= 20170216
	 */
	 private String nation = new String();

	/**
	 * 国家
	 *
	 * 版本 >= 20170216
	 */
	 private short nation_u;

	/**
	 * 国旗 url
	 *
	 * 版本 >= 20170216
	 */
	 private String flag = new String();

	/**
	 * 国旗 url
	 *
	 * 版本 >= 20170216
	 */
	 private short flag_u;

	/**
	 * 属性位
	 *
	 * 版本 >= 20170216
	 */
	 private BitSet property = new BitSet();

	/**
	 * 属性位
	 *
	 * 版本 >= 20170216
	 */
	 private short property_u;



	public int serialize(ByteStream bs) throws Exception
	{
		bs.pushUInt(getSize(bs.getDecodeCharset()) - 4);
		bs.pushUInt(version);
		bs.pushUByte(version_u);
		bs.pushUInt(brandId);
		bs.pushUByte(brandId_u);
		bs.pushString(brandName);
		bs.pushUByte(brandName_u);
		bs.pushString(brandNameCn);
		bs.pushUByte(brandNameCn_u);
		bs.pushString(brandNameEn);
		bs.pushUByte(brandNameEn_u);
		bs.pushString(brandDesc);
		bs.pushUByte(brandDesc_u);
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
		if(  this.version >= 20170216 ){
				bs.pushString(brandInitial);
		}
		if(  this.version >= 20170216 ){
				bs.pushUByte(brandInitial_u);
		}
		if(  this.version >= 20170216 ){
				bs.pushString(logo);
		}
		if(  this.version >= 20170216 ){
				bs.pushUByte(logo_u);
		}
		if(  this.version >= 20170216 ){
				bs.pushString(banner);
		}
		if(  this.version >= 20170216 ){
				bs.pushUByte(banner_u);
		}
		if(  this.version >= 20170216 ){
				bs.pushString(nation);
		}
		if(  this.version >= 20170216 ){
				bs.pushUByte(nation_u);
		}
		if(  this.version >= 20170216 ){
				bs.pushString(flag);
		}
		if(  this.version >= 20170216 ){
				bs.pushUByte(flag_u);
		}
		if(  this.version >= 20170216 ){
				bs.pushBitSet(property);
		}
		if(  this.version >= 20170216 ){
				bs.pushUByte(property_u);
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
		brandId = bs.popUInt();
		brandId_u = bs.popUByte();
		brandName = bs.popString();
		brandName_u = bs.popUByte();
		brandNameCn = bs.popString();
		brandNameCn_u = bs.popUByte();
		brandNameEn = bs.popString();
		brandNameEn_u = bs.popUByte();
		brandDesc = bs.popString();
		brandDesc_u = bs.popUByte();
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
		if(  this.version >= 20170216 ){
				brandInitial = bs.popString();
		}
		if(  this.version >= 20170216 ){
				brandInitial_u = bs.popUByte();
		}
		if(  this.version >= 20170216 ){
				logo = bs.popString();
		}
		if(  this.version >= 20170216 ){
				logo_u = bs.popUByte();
		}
		if(  this.version >= 20170216 ){
				banner = bs.popString();
		}
		if(  this.version >= 20170216 ){
				banner_u = bs.popUByte();
		}
		if(  this.version >= 20170216 ){
				nation = bs.popString();
		}
		if(  this.version >= 20170216 ){
				nation_u = bs.popUByte();
		}
		if(  this.version >= 20170216 ){
				flag = bs.popString();
		}
		if(  this.version >= 20170216 ){
				flag_u = bs.popUByte();
		}
		if(  this.version >= 20170216 ){
				property = bs.popBitSet();
		}
		if(  this.version >= 20170216 ){
				property_u = bs.popUByte();
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
	 * 获取品牌Id
	 * 
	 * 此字段的版本 >= 0
	 * @return brandId value 类型为:long
	 * 
	 */
	public long getBrandId()
	{
		return brandId;
	}


	/**
	 * 设置品牌Id
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setBrandId(long value)
	{
		this.brandId = value;
		this.brandId_u = 1;
	}

	public boolean issetBrandId()
	{
		return this.brandId_u != 0;
	}
	/**
	 * 获取
	 * 
	 * 此字段的版本 >= 0
	 * @return brandId_u value 类型为:short
	 * 
	 */
	public short getBrandId_u()
	{
		return brandId_u;
	}


	/**
	 * 设置
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	public void setBrandId_u(short value)
	{
		this.brandId_u = value;
	}


	/**
	 * 获取品牌名称
	 * 
	 * 此字段的版本 >= 0
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
	 * 此字段的版本 >= 0
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
	 * 获取
	 * 
	 * 此字段的版本 >= 0
	 * @return brandName_u value 类型为:short
	 * 
	 */
	public short getBrandName_u()
	{
		return brandName_u;
	}


	/**
	 * 设置
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	public void setBrandName_u(short value)
	{
		this.brandName_u = value;
	}


	/**
	 * 获取品牌名称(中文),如果没有为空
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
	 * 设置品牌名称(中文),如果没有为空
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
	 * 获取品牌名称(英文),如果没有为空
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
	 * 设置品牌名称(英文),如果没有为空
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
	 * 获取品牌描述信息
	 * 
	 * 此字段的版本 >= 0
	 * @return brandDesc value 类型为:String
	 * 
	 */
	public String getBrandDesc()
	{
		return brandDesc;
	}


	/**
	 * 设置品牌描述信息
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setBrandDesc(String value)
	{
		this.brandDesc = value;
		this.brandDesc_u = 1;
	}

	public boolean issetBrandDesc()
	{
		return this.brandDesc_u != 0;
	}
	/**
	 * 获取
	 * 
	 * 此字段的版本 >= 0
	 * @return brandDesc_u value 类型为:short
	 * 
	 */
	public short getBrandDesc_u()
	{
		return brandDesc_u;
	}


	/**
	 * 设置
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	public void setBrandDesc_u(short value)
	{
		this.brandDesc_u = value;
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
	 * 获取品牌首字母
	 * 
	 * 此字段的版本 >= 20170216
	 * @return brandInitial value 类型为:String
	 * 
	 */
	public String getBrandInitial()
	{
		return brandInitial;
	}


	/**
	 * 设置品牌首字母
	 * 
	 * 此字段的版本 >= 20170216
	 * @param  value 类型为:String
	 * 
	 */
	public void setBrandInitial(String value)
	{
		this.brandInitial = value;
		this.brandInitial_u = 1;
	}

	public boolean issetBrandInitial()
	{
		return this.brandInitial_u != 0;
	}
	/**
	 * 获取品牌首字母
	 * 
	 * 此字段的版本 >= 20170216
	 * @return brandInitial_u value 类型为:short
	 * 
	 */
	public short getBrandInitial_u()
	{
		return brandInitial_u;
	}


	/**
	 * 设置品牌首字母
	 * 
	 * 此字段的版本 >= 20170216
	 * @param  value 类型为:short
	 * 
	 */
	public void setBrandInitial_u(short value)
	{
		this.brandInitial_u = value;
	}


	/**
	 * 获取logo url
	 * 
	 * 此字段的版本 >= 20170216
	 * @return logo value 类型为:String
	 * 
	 */
	public String getLogo()
	{
		return logo;
	}


	/**
	 * 设置logo url
	 * 
	 * 此字段的版本 >= 20170216
	 * @param  value 类型为:String
	 * 
	 */
	public void setLogo(String value)
	{
		this.logo = value;
		this.logo_u = 1;
	}

	public boolean issetLogo()
	{
		return this.logo_u != 0;
	}
	/**
	 * 获取logo url
	 * 
	 * 此字段的版本 >= 20170216
	 * @return logo_u value 类型为:short
	 * 
	 */
	public short getLogo_u()
	{
		return logo_u;
	}


	/**
	 * 设置logo url
	 * 
	 * 此字段的版本 >= 20170216
	 * @param  value 类型为:short
	 * 
	 */
	public void setLogo_u(short value)
	{
		this.logo_u = value;
	}


	/**
	 * 获取banner url
	 * 
	 * 此字段的版本 >= 20170216
	 * @return banner value 类型为:String
	 * 
	 */
	public String getBanner()
	{
		return banner;
	}


	/**
	 * 设置banner url
	 * 
	 * 此字段的版本 >= 20170216
	 * @param  value 类型为:String
	 * 
	 */
	public void setBanner(String value)
	{
		this.banner = value;
		this.banner_u = 1;
	}

	public boolean issetBanner()
	{
		return this.banner_u != 0;
	}
	/**
	 * 获取banner url
	 * 
	 * 此字段的版本 >= 20170216
	 * @return banner_u value 类型为:short
	 * 
	 */
	public short getBanner_u()
	{
		return banner_u;
	}


	/**
	 * 设置banner url
	 * 
	 * 此字段的版本 >= 20170216
	 * @param  value 类型为:short
	 * 
	 */
	public void setBanner_u(short value)
	{
		this.banner_u = value;
	}


	/**
	 * 获取国家
	 * 
	 * 此字段的版本 >= 20170216
	 * @return nation value 类型为:String
	 * 
	 */
	public String getNation()
	{
		return nation;
	}


	/**
	 * 设置国家
	 * 
	 * 此字段的版本 >= 20170216
	 * @param  value 类型为:String
	 * 
	 */
	public void setNation(String value)
	{
		this.nation = value;
		this.nation_u = 1;
	}

	public boolean issetNation()
	{
		return this.nation_u != 0;
	}
	/**
	 * 获取国家
	 * 
	 * 此字段的版本 >= 20170216
	 * @return nation_u value 类型为:short
	 * 
	 */
	public short getNation_u()
	{
		return nation_u;
	}


	/**
	 * 设置国家
	 * 
	 * 此字段的版本 >= 20170216
	 * @param  value 类型为:short
	 * 
	 */
	public void setNation_u(short value)
	{
		this.nation_u = value;
	}


	/**
	 * 获取国旗 url
	 * 
	 * 此字段的版本 >= 20170216
	 * @return flag value 类型为:String
	 * 
	 */
	public String getFlag()
	{
		return flag;
	}


	/**
	 * 设置国旗 url
	 * 
	 * 此字段的版本 >= 20170216
	 * @param  value 类型为:String
	 * 
	 */
	public void setFlag(String value)
	{
		this.flag = value;
		this.flag_u = 1;
	}

	public boolean issetFlag()
	{
		return this.flag_u != 0;
	}
	/**
	 * 获取国旗 url
	 * 
	 * 此字段的版本 >= 20170216
	 * @return flag_u value 类型为:short
	 * 
	 */
	public short getFlag_u()
	{
		return flag_u;
	}


	/**
	 * 设置国旗 url
	 * 
	 * 此字段的版本 >= 20170216
	 * @param  value 类型为:short
	 * 
	 */
	public void setFlag_u(short value)
	{
		this.flag_u = value;
	}


	/**
	 * 获取属性位
	 * 
	 * 此字段的版本 >= 20170216
	 * @return property value 类型为:BitSet
	 * 
	 */
	public BitSet getProperty()
	{
		return property;
	}


	/**
	 * 设置属性位
	 * 
	 * 此字段的版本 >= 20170216
	 * @param  value 类型为:BitSet
	 * 
	 */
	public void setProperty(BitSet value)
	{
		if (value != null) {
				this.property = value;
				this.property_u = 1;
		}
	}

	public boolean issetProperty()
	{
		return this.property_u != 0;
	}
	/**
	 * 获取属性位
	 * 
	 * 此字段的版本 >= 20170216
	 * @return property_u value 类型为:short
	 * 
	 */
	public short getProperty_u()
	{
		return property_u;
	}


	/**
	 * 设置属性位
	 * 
	 * 此字段的版本 >= 20170216
	 * @param  value 类型为:short
	 * 
	 */
	public void setProperty_u(short value)
	{
		this.property_u = value;
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
				length = 4;  //size_of(Brand)
				length += 4;  //计算字段version的长度 size_of(uint32_t)
				length += 1;  //计算字段version_u的长度 size_of(uint8_t)
				length += 4;  //计算字段brandId的长度 size_of(uint32_t)
				length += 1;  //计算字段brandId_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandName, null);  //计算字段brandName的长度 size_of(String)
				length += 1;  //计算字段brandName_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandNameCn, null);  //计算字段brandNameCn的长度 size_of(String)
				length += 1;  //计算字段brandNameCn_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandNameEn, null);  //计算字段brandNameEn的长度 size_of(String)
				length += 1;  //计算字段brandNameEn_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandDesc, null);  //计算字段brandDesc的长度 size_of(String)
				length += 1;  //计算字段brandDesc_u的长度 size_of(uint8_t)
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
				if(  this.version >= 20170216 ){
						length += ByteStream.getObjectSize(brandInitial, null);  //计算字段brandInitial的长度 size_of(String)
				}
				if(  this.version >= 20170216 ){
						length += 1;  //计算字段brandInitial_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20170216 ){
						length += ByteStream.getObjectSize(logo, null);  //计算字段logo的长度 size_of(String)
				}
				if(  this.version >= 20170216 ){
						length += 1;  //计算字段logo_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20170216 ){
						length += ByteStream.getObjectSize(banner, null);  //计算字段banner的长度 size_of(String)
				}
				if(  this.version >= 20170216 ){
						length += 1;  //计算字段banner_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20170216 ){
						length += ByteStream.getObjectSize(nation, null);  //计算字段nation的长度 size_of(String)
				}
				if(  this.version >= 20170216 ){
						length += 1;  //计算字段nation_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20170216 ){
						length += ByteStream.getObjectSize(flag, null);  //计算字段flag的长度 size_of(String)
				}
				if(  this.version >= 20170216 ){
						length += 1;  //计算字段flag_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20170216 ){
						length += ByteStream.getObjectSize(property, null);  //计算字段property的长度 size_of(BitSet)
				}
				if(  this.version >= 20170216 ){
						length += 1;  //计算字段property_u的长度 size_of(uint8_t)
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
				length = 4;  //size_of(Brand)
				length += 4;  //计算字段version的长度 size_of(uint32_t)
				length += 1;  //计算字段version_u的长度 size_of(uint8_t)
				length += 4;  //计算字段brandId的长度 size_of(uint32_t)
				length += 1;  //计算字段brandId_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandName, encoding);  //计算字段brandName的长度 size_of(String)
				length += 1;  //计算字段brandName_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandNameCn, encoding);  //计算字段brandNameCn的长度 size_of(String)
				length += 1;  //计算字段brandNameCn_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandNameEn, encoding);  //计算字段brandNameEn的长度 size_of(String)
				length += 1;  //计算字段brandNameEn_u的长度 size_of(uint8_t)
				length += ByteStream.getObjectSize(brandDesc, encoding);  //计算字段brandDesc的长度 size_of(String)
				length += 1;  //计算字段brandDesc_u的长度 size_of(uint8_t)
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
				if(  this.version >= 20170216 ){
						length += ByteStream.getObjectSize(brandInitial, encoding);  //计算字段brandInitial的长度 size_of(String)
				}
				if(  this.version >= 20170216 ){
						length += 1;  //计算字段brandInitial_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20170216 ){
						length += ByteStream.getObjectSize(logo, encoding);  //计算字段logo的长度 size_of(String)
				}
				if(  this.version >= 20170216 ){
						length += 1;  //计算字段logo_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20170216 ){
						length += ByteStream.getObjectSize(banner, encoding);  //计算字段banner的长度 size_of(String)
				}
				if(  this.version >= 20170216 ){
						length += 1;  //计算字段banner_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20170216 ){
						length += ByteStream.getObjectSize(nation, encoding);  //计算字段nation的长度 size_of(String)
				}
				if(  this.version >= 20170216 ){
						length += 1;  //计算字段nation_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20170216 ){
						length += ByteStream.getObjectSize(flag, encoding);  //计算字段flag的长度 size_of(String)
				}
				if(  this.version >= 20170216 ){
						length += 1;  //计算字段flag_u的长度 size_of(uint8_t)
				}
				if(  this.version >= 20170216 ){
						length += ByteStream.getObjectSize(property, encoding);  //计算字段property的长度 size_of(BitSet)
				}
				if(  this.version >= 20170216 ){
						length += 1;  //计算字段property_u的长度 size_of(uint8_t)
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
 *	long brandId;///<品牌Id
 *	short brandId_u;
 *	String brandName;///<品牌名称
 *	short brandName_u;
 *	String brandNameCn;///<品牌名称(中文),如果没有为空
 *	short brandNameCn_u;
 *	String brandNameEn;///<品牌名称(英文),如果没有为空
 *	short brandNameEn_u;
 *	String brandDesc;///<品牌描述信息
 *	short brandDesc_u;
 *	String erpBrandId;///<ERP品牌Id
 *	short erpBrandId_u;///<ERP品牌Id
 *	String erpBrandName;///<ERP品牌名称
 *	short erpBrandName_u;///<ERP品牌名称
 *****以上是版本20161012所包含的字段*******
 *
 *****以下是版本20170216所包含的字段*******
 *	long version;///<PO版本号 
 *	short version_u;
 *	long brandId;///<品牌Id
 *	short brandId_u;
 *	String brandName;///<品牌名称
 *	short brandName_u;
 *	String brandNameCn;///<品牌名称(中文),如果没有为空
 *	short brandNameCn_u;
 *	String brandNameEn;///<品牌名称(英文),如果没有为空
 *	short brandNameEn_u;
 *	String brandDesc;///<品牌描述信息
 *	short brandDesc_u;
 *	String erpBrandId;///<ERP品牌Id
 *	short erpBrandId_u;///<ERP品牌Id
 *	String erpBrandName;///<ERP品牌名称
 *	short erpBrandName_u;///<ERP品牌名称
 *	String brandInitial;///<品牌首字母
 *	short brandInitial_u;///<品牌首字母
 *	String logo;///<logo url
 *	short logo_u;///<logo url
 *	String banner;///<banner url
 *	short banner_u;///<banner url
 *	String nation;///<国家
 *	short nation_u;///<国家
 *	String flag;///<国旗 url
 *	short flag_u;///<国旗 url
 *	BitSet property;///<属性位
 *	short property_u;///<属性位
 *****以上是版本20170216所包含的字段*******
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
