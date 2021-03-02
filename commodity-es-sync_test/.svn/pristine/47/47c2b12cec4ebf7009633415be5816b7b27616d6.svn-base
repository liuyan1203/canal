//auto gen by paipai.java.augogen ver 1.0
//auther skyzhuang
//source idl: com.b2b2c.nca.idl.Result_GetItemInfo_ALL.java

package com.haiziwang.commodity.cpp.response;


import com.paipai.lang.uint32_t;
import com.paipai.util.io.ByteStream;
import com.paipai.util.io.ICanSerializeObjectExt4Encoding;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 导航简易结构体 
 *
 *@date 2020-02-22 03:15:38
 *
 *@since version:0
*/
public class NavEntryDdo  implements ICanSerializeObjectExt4Encoding
{
	/**
	 *  版本号, version需要小写 
	 *
	 * 版本 >= 0
	 */
	 private short version = 146;

	/**
	 *  导航id 
	 *
	 * 版本 >= 0
	 */
	 private long NavId;

	/**
	 * 地图id
	 *
	 * 版本 >= 0
	 */
	 private long MapId;

	/**
	 *  父导航id 
	 *
	 * 版本 >= 0
	 */
	 private long PNavId;

	/**
	 *  导航名称 
	 *
	 * 版本 >= 0
	 */
	 private String Name = new String();

	/**
	 *  导航类型 
	 *
	 * 版本 >= 0
	 */
	 private long Type;

	/**
	 *  导航分类 
	 *
	 * 版本 >= 0
	 */
	 private long Catalog;

	/**
	 *  备注 
	 *
	 * 版本 >= 0
	 */
	 private String Note = new String();

	/**
	 *  排序字段 
	 *
	 * 版本 >= 0
	 */
	 private long Order;

	/**
	 *  导航property 
	 *
	 * 版本 >= 0
	 */
	 private String PropertyStr = new String();

	/**
	 *  搜索条件 
	 *
	 * 版本 >= 0
	 */
	 private String SearchCond = new String();

	/**
	 *  是否有属性 
	 *
	 * 版本 >= 0
	 */
	 private long HasAttr;

	/**
	 *  导航预留自定义串1 
	 *
	 * 版本 >= 0
	 */
	 private String CustomStr1 = new String();

	/**
	 *  导航预留自定义串2 
	 *
	 * 版本 >= 0
	 */
	 private String CustomStr2 = new String();

	/**
	 *  导航预留自定义整形字段1 
	 *
	 * 版本 >= 0
	 */
	 private long CustomUint1;

	/**
	 *  导航预留自定义整形字段2 
	 *
	 * 版本 >= 0
	 */
	 private long CustomUint2;

	/**
	 *  是否预删除，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsPreDelete;

	/**
	 *  是否合作伙伴优先，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsCooperatorFirst;

	/**
	 *  是否低价优先，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsLowPriceFirst;

	/**
	 *  是否高价优先，0为否，其余为是 
	 *
	 * 版本 >= 140
	 */
	 private long IsHighPriceFirst;

	/**
	 * 标记位，具体定义参见CLASS_PROPERTY
	 *
	 * 版本 >= 141
	 */
	 private BitSet PropertyMask = new BitSet();

	/**
	 * 额外数据，key是业务id，value是业务数据
	 *
	 * 版本 >= 142
	 */
	 private Map<uint32_t,String> ExtraData = new HashMap<uint32_t,String>();

	/**
	 * 图片url
	 *
	 * 版本 >= 143
	 */
	 private String Photo = new String();

	/**
	 * 图片链接url
	 *
	 * 版本 >= 143
	 */
	 private String Link = new String();

	/**
	 * 图片和链接有效时间
	 *
	 * 版本 >= 144
	 */
	 private long startTime;

	/**
	 * 图片和链接有效时间
	 *
	 * 版本 >= 144
	 */
	 private long endTime;

	/**
	 * erpClssId
	 *
	 * 版本 >= 145
	 */
	 private String ErpClassId = new String();

	/**
	 * erpClassName
	 *
	 * 版本 >= 145
	 */
	 private String ErpClassName = new String();

	/**
	 *  小租户搜索导航挂载方式 
	 *
	 * 版本 >= 146
	 */
	 private long StoreNavType;



	public int serialize(ByteStream bs) throws Exception
	{
		bs.pushUInt(getSize(bs.getDecodeCharset()) - 4);
		bs.pushUByte(version);
		bs.pushUInt(NavId);
		bs.pushUInt(MapId);
		bs.pushUInt(PNavId);
		bs.pushString(Name);
		bs.pushUInt(Type);
		bs.pushUInt(Catalog);
		bs.pushString(Note);
		bs.pushUInt(Order);
		bs.pushString(PropertyStr);
		bs.pushString(SearchCond);
		bs.pushUInt(HasAttr);
		bs.pushString(CustomStr1);
		bs.pushString(CustomStr2);
		bs.pushUInt(CustomUint1);
		bs.pushUInt(CustomUint2);
		if(  this.version >= 140 ){
				bs.pushUInt(IsPreDelete);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsCooperatorFirst);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsLowPriceFirst);
		}
		if(  this.version >= 140 ){
				bs.pushUInt(IsHighPriceFirst);
		}
		if(  this.version >= 141 ){
				bs.pushBitSet(PropertyMask);
		}
		if(  this.version >= 142 ){
				bs.pushObject(ExtraData);
		}
		if(  this.version >= 143 ){
				bs.pushString(Photo);
		}
		if(  this.version >= 143 ){
				bs.pushString(Link);
		}
		if(  this.version >= 144 ){
				bs.pushUInt(startTime);
		}
		if(  this.version >= 144 ){
				bs.pushUInt(endTime);
		}
		if(  this.version >= 145 ){
				bs.pushString(ErpClassId);
		}
		if(  this.version >= 145 ){
				bs.pushString(ErpClassName);
		}
		if(  this.version >= 146 ){
				bs.pushUInt(StoreNavType);
		}
		return bs.getWrittenLength();
	}
	
	public int unSerialize(ByteStream bs) throws Exception
	{
		long size = bs.popUInt();
		int startPosPop = bs.getReadLength();
		if (size == 0)
				return 0;
		version = bs.popUByte();
		NavId = bs.popUInt();
		MapId = bs.popUInt();
		PNavId = bs.popUInt();
		Name = bs.popString();
		Type = bs.popUInt();
		Catalog = bs.popUInt();
		Note = bs.popString();
		Order = bs.popUInt();
		PropertyStr = bs.popString();
		SearchCond = bs.popString();
		HasAttr = bs.popUInt();
		CustomStr1 = bs.popString();
		CustomStr2 = bs.popString();
		CustomUint1 = bs.popUInt();
		CustomUint2 = bs.popUInt();
		if(  version >= 140 ){
				IsPreDelete = bs.popUInt();
		}
		if(  version >= 140 ){
				IsCooperatorFirst = bs.popUInt();
		}
		if(  version >= 140 ){
				IsLowPriceFirst = bs.popUInt();
		}
		if(  version >= 140 ){
				IsHighPriceFirst = bs.popUInt();
		}
		if(  version >= 141 ){
				PropertyMask = bs.popBitSet();
		}
		if(  version >= 142 ){
				ExtraData = (Map<uint32_t,String>)bs.popMap(uint32_t.class,String.class);
		}
		if(  version >= 143 ){
				Photo = bs.popString();
		}
		if(  version >= 143 ){
				Link = bs.popString();
		}
		if(  version >= 144 ){
				startTime = bs.popUInt();
		}
		if(  version >= 144 ){
				endTime = bs.popUInt();
		}
		if(  version >= 145 ){
				ErpClassId = bs.popString();
		}
		if(  version >= 145 ){
				ErpClassName = bs.popString();
		}
		if(  version >= 146 ){
				StoreNavType = bs.popUInt();
		}

		/**********************为了支持多个版本的客户端************************/
		int needPopBytes = (int)size - (bs.getReadLength() - startPosPop);
		for(int i = 0;i< needPopBytes; i++)
				bs.popByte();
		/**********************为了支持多个版本的客户端************************/

		return bs.getReadLength();
	} 


	/**
	 * 获取 版本号, version需要小写 
	 * 
	 * 此字段的版本 >= 0
	 * @return version value 类型为:short
	 * 
	 */
	public short getVersion()
	{
		return version;
	}


	/**
	 * 设置 版本号, version需要小写 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:short
	 * 
	 */
	private void setVersion(short value)
	{
		this.version = value;
	}


	/**
	 * 获取 导航id 
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
	 * 设置 导航id 
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
	 * 获取地图id
	 * 
	 * 此字段的版本 >= 0
	 * @return MapId value 类型为:long
	 * 
	 */
	public long getMapId()
	{
		return MapId;
	}


	/**
	 * 设置地图id
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setMapId(long value)
	{
		this.MapId = value;
	}


	/**
	 * 获取 父导航id 
	 * 
	 * 此字段的版本 >= 0
	 * @return PNavId value 类型为:long
	 * 
	 */
	public long getPNavId()
	{
		return PNavId;
	}


	/**
	 * 设置 父导航id 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setPNavId(long value)
	{
		this.PNavId = value;
	}


	/**
	 * 获取 导航名称 
	 * 
	 * 此字段的版本 >= 0
	 * @return Name value 类型为:String
	 * 
	 */
	public String getName()
	{
		return Name;
	}


	/**
	 * 设置 导航名称 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setName(String value)
	{
		this.Name = value;
	}


	/**
	 * 获取 导航类型 
	 * 
	 * 此字段的版本 >= 0
	 * @return Type value 类型为:long
	 * 
	 */
	public long getType()
	{
		return Type;
	}


	/**
	 * 设置 导航类型 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setType(long value)
	{
		this.Type = value;
	}


	/**
	 * 获取 导航分类 
	 * 
	 * 此字段的版本 >= 0
	 * @return Catalog value 类型为:long
	 * 
	 */
	public long getCatalog()
	{
		return Catalog;
	}


	/**
	 * 设置 导航分类 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setCatalog(long value)
	{
		this.Catalog = value;
	}


	/**
	 * 获取 备注 
	 * 
	 * 此字段的版本 >= 0
	 * @return Note value 类型为:String
	 * 
	 */
	public String getNote()
	{
		return Note;
	}


	/**
	 * 设置 备注 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setNote(String value)
	{
		this.Note = value;
	}


	/**
	 * 获取 排序字段 
	 * 
	 * 此字段的版本 >= 0
	 * @return Order value 类型为:long
	 * 
	 */
	public long getOrder()
	{
		return Order;
	}


	/**
	 * 设置 排序字段 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setOrder(long value)
	{
		this.Order = value;
	}


	/**
	 * 获取 导航property 
	 * 
	 * 此字段的版本 >= 0
	 * @return PropertyStr value 类型为:String
	 * 
	 */
	public String getPropertyStr()
	{
		return PropertyStr;
	}


	/**
	 * 设置 导航property 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setPropertyStr(String value)
	{
		this.PropertyStr = value;
	}


	/**
	 * 获取 搜索条件 
	 * 
	 * 此字段的版本 >= 0
	 * @return SearchCond value 类型为:String
	 * 
	 */
	public String getSearchCond()
	{
		return SearchCond;
	}


	/**
	 * 设置 搜索条件 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setSearchCond(String value)
	{
		this.SearchCond = value;
	}


	/**
	 * 获取 是否有属性 
	 * 
	 * 此字段的版本 >= 0
	 * @return HasAttr value 类型为:long
	 * 
	 */
	public long getHasAttr()
	{
		return HasAttr;
	}


	/**
	 * 设置 是否有属性 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setHasAttr(long value)
	{
		this.HasAttr = value;
	}


	/**
	 * 获取 导航预留自定义串1 
	 * 
	 * 此字段的版本 >= 0
	 * @return CustomStr1 value 类型为:String
	 * 
	 */
	public String getCustomStr1()
	{
		return CustomStr1;
	}


	/**
	 * 设置 导航预留自定义串1 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setCustomStr1(String value)
	{
		this.CustomStr1 = value;
	}


	/**
	 * 获取 导航预留自定义串2 
	 * 
	 * 此字段的版本 >= 0
	 * @return CustomStr2 value 类型为:String
	 * 
	 */
	public String getCustomStr2()
	{
		return CustomStr2;
	}


	/**
	 * 设置 导航预留自定义串2 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:String
	 * 
	 */
	public void setCustomStr2(String value)
	{
		this.CustomStr2 = value;
	}


	/**
	 * 获取 导航预留自定义整形字段1 
	 * 
	 * 此字段的版本 >= 0
	 * @return CustomUint1 value 类型为:long
	 * 
	 */
	public long getCustomUint1()
	{
		return CustomUint1;
	}


	/**
	 * 设置 导航预留自定义整形字段1 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setCustomUint1(long value)
	{
		this.CustomUint1 = value;
	}


	/**
	 * 获取 导航预留自定义整形字段2 
	 * 
	 * 此字段的版本 >= 0
	 * @return CustomUint2 value 类型为:long
	 * 
	 */
	public long getCustomUint2()
	{
		return CustomUint2;
	}


	/**
	 * 设置 导航预留自定义整形字段2 
	 * 
	 * 此字段的版本 >= 0
	 * @param  value 类型为:long
	 * 
	 */
	public void setCustomUint2(long value)
	{
		this.CustomUint2 = value;
	}


	/**
	 * 获取 是否预删除，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsPreDelete value 类型为:long
	 * 
	 */
	public long getIsPreDelete()
	{
		return IsPreDelete;
	}


	/**
	 * 设置 是否预删除，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsPreDelete(long value)
	{
		this.IsPreDelete = value;
	}


	/**
	 * 获取 是否合作伙伴优先，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsCooperatorFirst value 类型为:long
	 * 
	 */
	public long getIsCooperatorFirst()
	{
		return IsCooperatorFirst;
	}


	/**
	 * 设置 是否合作伙伴优先，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsCooperatorFirst(long value)
	{
		this.IsCooperatorFirst = value;
	}


	/**
	 * 获取 是否低价优先，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsLowPriceFirst value 类型为:long
	 * 
	 */
	public long getIsLowPriceFirst()
	{
		return IsLowPriceFirst;
	}


	/**
	 * 设置 是否低价优先，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsLowPriceFirst(long value)
	{
		this.IsLowPriceFirst = value;
	}


	/**
	 * 获取 是否高价优先，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @return IsHighPriceFirst value 类型为:long
	 * 
	 */
	public long getIsHighPriceFirst()
	{
		return IsHighPriceFirst;
	}


	/**
	 * 设置 是否高价优先，0为否，其余为是 
	 * 
	 * 此字段的版本 >= 140
	 * @param  value 类型为:long
	 * 
	 */
	public void setIsHighPriceFirst(long value)
	{
		this.IsHighPriceFirst = value;
	}


	/**
	 * 获取标记位，具体定义参见CLASS_PROPERTY
	 * 
	 * 此字段的版本 >= 141
	 * @return PropertyMask value 类型为:BitSet
	 * 
	 */
	public BitSet getPropertyMask()
	{
		return PropertyMask;
	}


	/**
	 * 设置标记位，具体定义参见CLASS_PROPERTY
	 * 
	 * 此字段的版本 >= 141
	 * @param  value 类型为:BitSet
	 * 
	 */
	public void setPropertyMask(BitSet value)
	{
		if (value != null) {
				this.PropertyMask = value;
		}else{
				this.PropertyMask = new BitSet();
		}
	}


	/**
	 * 获取额外数据，key是业务id，value是业务数据
	 * 
	 * 此字段的版本 >= 142
	 * @return ExtraData value 类型为:Map<uint32_t,String>
	 * 
	 */
	public Map<uint32_t,String> getExtraData()
	{
		return ExtraData;
	}


	/**
	 * 设置额外数据，key是业务id，value是业务数据
	 * 
	 * 此字段的版本 >= 142
	 * @param  value 类型为:Map<uint32_t,String>
	 * 
	 */
	public void setExtraData(Map<uint32_t,String> value)
	{
		if (value != null) {
				this.ExtraData = value;
		}else{
				this.ExtraData = new HashMap<uint32_t,String>();
		}
	}


	/**
	 * 获取图片url
	 * 
	 * 此字段的版本 >= 143
	 * @return Photo value 类型为:String
	 * 
	 */
	public String getPhoto()
	{
		return Photo;
	}


	/**
	 * 设置图片url
	 * 
	 * 此字段的版本 >= 143
	 * @param  value 类型为:String
	 * 
	 */
	public void setPhoto(String value)
	{
		this.Photo = value;
	}


	/**
	 * 获取图片链接url
	 * 
	 * 此字段的版本 >= 143
	 * @return Link value 类型为:String
	 * 
	 */
	public String getLink()
	{
		return Link;
	}


	/**
	 * 设置图片链接url
	 * 
	 * 此字段的版本 >= 143
	 * @param  value 类型为:String
	 * 
	 */
	public void setLink(String value)
	{
		this.Link = value;
	}


	/**
	 * 获取图片和链接有效时间
	 * 
	 * 此字段的版本 >= 144
	 * @return startTime value 类型为:long
	 * 
	 */
	public long getStartTime()
	{
		return startTime;
	}


	/**
	 * 设置图片和链接有效时间
	 * 
	 * 此字段的版本 >= 144
	 * @param  value 类型为:long
	 * 
	 */
	public void setStartTime(long value)
	{
		this.startTime = value;
	}


	/**
	 * 获取图片和链接有效时间
	 * 
	 * 此字段的版本 >= 144
	 * @return endTime value 类型为:long
	 * 
	 */
	public long getEndTime()
	{
		return endTime;
	}


	/**
	 * 设置图片和链接有效时间
	 * 
	 * 此字段的版本 >= 144
	 * @param  value 类型为:long
	 * 
	 */
	public void setEndTime(long value)
	{
		this.endTime = value;
	}


	/**
	 * 获取erpClssId
	 * 
	 * 此字段的版本 >= 145
	 * @return ErpClassId value 类型为:String
	 * 
	 */
	public String getErpClassId()
	{
		return ErpClassId;
	}


	/**
	 * 设置erpClssId
	 * 
	 * 此字段的版本 >= 145
	 * @param  value 类型为:String
	 * 
	 */
	public void setErpClassId(String value)
	{
		this.ErpClassId = value;
	}


	/**
	 * 获取erpClassName
	 * 
	 * 此字段的版本 >= 145
	 * @return ErpClassName value 类型为:String
	 * 
	 */
	public String getErpClassName()
	{
		return ErpClassName;
	}


	/**
	 * 设置erpClassName
	 * 
	 * 此字段的版本 >= 145
	 * @param  value 类型为:String
	 * 
	 */
	public void setErpClassName(String value)
	{
		this.ErpClassName = value;
	}


	/**
	 * 获取 小租户搜索导航挂载方式 
	 * 
	 * 此字段的版本 >= 146
	 * @return StoreNavType value 类型为:long
	 * 
	 */
	public long getStoreNavType()
	{
		return StoreNavType;
	}


	/**
	 * 设置 小租户搜索导航挂载方式 
	 * 
	 * 此字段的版本 >= 146
	 * @param  value 类型为:long
	 * 
	 */
	public void setStoreNavType(long value)
	{
		this.StoreNavType = value;
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
				length = 4;  //size_of(NavEntryDdo)
				length += 1;  //计算字段version的长度 size_of(uint8_t)
				length += 4;  //计算字段NavId的长度 size_of(uint32_t)
				length += 4;  //计算字段MapId的长度 size_of(uint32_t)
				length += 4;  //计算字段PNavId的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(Name, null);  //计算字段Name的长度 size_of(String)
				length += 4;  //计算字段Type的长度 size_of(uint32_t)
				length += 4;  //计算字段Catalog的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(Note, null);  //计算字段Note的长度 size_of(String)
				length += 4;  //计算字段Order的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(PropertyStr, null);  //计算字段PropertyStr的长度 size_of(String)
				length += ByteStream.getObjectSize(SearchCond, null);  //计算字段SearchCond的长度 size_of(String)
				length += 4;  //计算字段HasAttr的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(CustomStr1, null);  //计算字段CustomStr1的长度 size_of(String)
				length += ByteStream.getObjectSize(CustomStr2, null);  //计算字段CustomStr2的长度 size_of(String)
				length += 4;  //计算字段CustomUint1的长度 size_of(uint32_t)
				length += 4;  //计算字段CustomUint2的长度 size_of(uint32_t)
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsPreDelete的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsCooperatorFirst的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsLowPriceFirst的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsHighPriceFirst的长度 size_of(uint32_t)
				}
				if(  this.version >= 141 ){
						length += ByteStream.getObjectSize(PropertyMask, null);  //计算字段PropertyMask的长度 size_of(BitSet)
				}
				if(  this.version >= 142 ){
						length += ByteStream.getObjectSize(ExtraData, null);  //计算字段ExtraData的长度 size_of(Map)
				}
				if(  this.version >= 143 ){
						length += ByteStream.getObjectSize(Photo, null);  //计算字段Photo的长度 size_of(String)
				}
				if(  this.version >= 143 ){
						length += ByteStream.getObjectSize(Link, null);  //计算字段Link的长度 size_of(String)
				}
				if(  this.version >= 144 ){
						length += 4;  //计算字段startTime的长度 size_of(uint32_t)
				}
				if(  this.version >= 144 ){
						length += 4;  //计算字段endTime的长度 size_of(uint32_t)
				}
				if(  this.version >= 145 ){
						length += ByteStream.getObjectSize(ErpClassId, null);  //计算字段ErpClassId的长度 size_of(String)
				}
				if(  this.version >= 145 ){
						length += ByteStream.getObjectSize(ErpClassName, null);  //计算字段ErpClassName的长度 size_of(String)
				}
				if(  this.version >= 146 ){
						length += 4;  //计算字段StoreNavType的长度 size_of(uint32_t)
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
				length = 4;  //size_of(NavEntryDdo)
				length += 1;  //计算字段version的长度 size_of(uint8_t)
				length += 4;  //计算字段NavId的长度 size_of(uint32_t)
				length += 4;  //计算字段MapId的长度 size_of(uint32_t)
				length += 4;  //计算字段PNavId的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(Name, encoding);  //计算字段Name的长度 size_of(String)
				length += 4;  //计算字段Type的长度 size_of(uint32_t)
				length += 4;  //计算字段Catalog的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(Note, encoding);  //计算字段Note的长度 size_of(String)
				length += 4;  //计算字段Order的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(PropertyStr, encoding);  //计算字段PropertyStr的长度 size_of(String)
				length += ByteStream.getObjectSize(SearchCond, encoding);  //计算字段SearchCond的长度 size_of(String)
				length += 4;  //计算字段HasAttr的长度 size_of(uint32_t)
				length += ByteStream.getObjectSize(CustomStr1, encoding);  //计算字段CustomStr1的长度 size_of(String)
				length += ByteStream.getObjectSize(CustomStr2, encoding);  //计算字段CustomStr2的长度 size_of(String)
				length += 4;  //计算字段CustomUint1的长度 size_of(uint32_t)
				length += 4;  //计算字段CustomUint2的长度 size_of(uint32_t)
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsPreDelete的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsCooperatorFirst的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsLowPriceFirst的长度 size_of(uint32_t)
				}
				if(  this.version >= 140 ){
						length += 4;  //计算字段IsHighPriceFirst的长度 size_of(uint32_t)
				}
				if(  this.version >= 141 ){
						length += ByteStream.getObjectSize(PropertyMask, encoding);  //计算字段PropertyMask的长度 size_of(BitSet)
				}
				if(  this.version >= 142 ){
						length += ByteStream.getObjectSize(ExtraData, encoding);  //计算字段ExtraData的长度 size_of(Map)
				}
				if(  this.version >= 143 ){
						length += ByteStream.getObjectSize(Photo, encoding);  //计算字段Photo的长度 size_of(String)
				}
				if(  this.version >= 143 ){
						length += ByteStream.getObjectSize(Link, encoding);  //计算字段Link的长度 size_of(String)
				}
				if(  this.version >= 144 ){
						length += 4;  //计算字段startTime的长度 size_of(uint32_t)
				}
				if(  this.version >= 144 ){
						length += 4;  //计算字段endTime的长度 size_of(uint32_t)
				}
				if(  this.version >= 145 ){
						length += ByteStream.getObjectSize(ErpClassId, encoding);  //计算字段ErpClassId的长度 size_of(String)
				}
				if(  this.version >= 145 ){
						length += ByteStream.getObjectSize(ErpClassName, encoding);  //计算字段ErpClassName的长度 size_of(String)
				}
				if(  this.version >= 146 ){
						length += 4;  //计算字段StoreNavType的长度 size_of(uint32_t)
				}
		}catch(Exception e){
				e.printStackTrace();
		}
		return length;
	}


/**
 ********************以下信息是每个版本的字段********************
 *
 *****以下是版本144所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long NavId;///< 导航id 
 *	long MapId;///<地图id
 *	long PNavId;///< 父导航id 
 *	String Name;///< 导航名称 
 *	long Type;///< 导航类型 
 *	long Catalog;///< 导航分类 
 *	String Note;///< 备注 
 *	long Order;///< 排序字段 
 *	String PropertyStr;///< 导航property 
 *	String SearchCond;///< 搜索条件 
 *	long HasAttr;///< 是否有属性 
 *	String CustomStr1;///< 导航预留自定义串1 
 *	String CustomStr2;///< 导航预留自定义串2 
 *	long CustomUint1;///< 导航预留自定义整形字段1 
 *	long CustomUint2;///< 导航预留自定义整形字段2 
 *	long IsPreDelete;///< 是否预删除，0为否，其余为是 
 *	long IsCooperatorFirst;///< 是否合作伙伴优先，0为否，其余为是 
 *	long IsLowPriceFirst;///< 是否低价优先，0为否，其余为是 
 *	long IsHighPriceFirst;///< 是否高价优先，0为否，其余为是 
 *	BitSet PropertyMask;///<标记位，具体定义参见CLASS_PROPERTY
 *	Map<uint32_t,String> ExtraData;///<额外数据，key是业务id，value是业务数据
 *	String Photo;///<图片url
 *	String Link;///<图片链接url
 *	long startTime;///<图片和链接有效时间
 *	long endTime;///<图片和链接有效时间
 *****以上是版本144所包含的字段*******
 *
 *****以下是版本145所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long NavId;///< 导航id 
 *	long MapId;///<地图id
 *	long PNavId;///< 父导航id 
 *	String Name;///< 导航名称 
 *	long Type;///< 导航类型 
 *	long Catalog;///< 导航分类 
 *	String Note;///< 备注 
 *	long Order;///< 排序字段 
 *	String PropertyStr;///< 导航property 
 *	String SearchCond;///< 搜索条件 
 *	long HasAttr;///< 是否有属性 
 *	String CustomStr1;///< 导航预留自定义串1 
 *	String CustomStr2;///< 导航预留自定义串2 
 *	long CustomUint1;///< 导航预留自定义整形字段1 
 *	long CustomUint2;///< 导航预留自定义整形字段2 
 *	long IsPreDelete;///< 是否预删除，0为否，其余为是 
 *	long IsCooperatorFirst;///< 是否合作伙伴优先，0为否，其余为是 
 *	long IsLowPriceFirst;///< 是否低价优先，0为否，其余为是 
 *	long IsHighPriceFirst;///< 是否高价优先，0为否，其余为是 
 *	BitSet PropertyMask;///<标记位，具体定义参见CLASS_PROPERTY
 *	Map<uint32_t,String> ExtraData;///<额外数据，key是业务id，value是业务数据
 *	String Photo;///<图片url
 *	String Link;///<图片链接url
 *	long startTime;///<图片和链接有效时间
 *	long endTime;///<图片和链接有效时间
 *	String ErpClassId;///<erpClssId
 *	String ErpClassName;///<erpClassName
 *****以上是版本145所包含的字段*******
 *
 *****以下是版本146所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long NavId;///< 导航id 
 *	long MapId;///<地图id
 *	long PNavId;///< 父导航id 
 *	String Name;///< 导航名称 
 *	long Type;///< 导航类型 
 *	long Catalog;///< 导航分类 
 *	String Note;///< 备注 
 *	long Order;///< 排序字段 
 *	String PropertyStr;///< 导航property 
 *	String SearchCond;///< 搜索条件 
 *	long HasAttr;///< 是否有属性 
 *	String CustomStr1;///< 导航预留自定义串1 
 *	String CustomStr2;///< 导航预留自定义串2 
 *	long CustomUint1;///< 导航预留自定义整形字段1 
 *	long CustomUint2;///< 导航预留自定义整形字段2 
 *	long IsPreDelete;///< 是否预删除，0为否，其余为是 
 *	long IsCooperatorFirst;///< 是否合作伙伴优先，0为否，其余为是 
 *	long IsLowPriceFirst;///< 是否低价优先，0为否，其余为是 
 *	long IsHighPriceFirst;///< 是否高价优先，0为否，其余为是 
 *	BitSet PropertyMask;///<标记位，具体定义参见CLASS_PROPERTY
 *	Map<uint32_t,String> ExtraData;///<额外数据，key是业务id，value是业务数据
 *	String Photo;///<图片url
 *	String Link;///<图片链接url
 *	long startTime;///<图片和链接有效时间
 *	long endTime;///<图片和链接有效时间
 *	String ErpClassId;///<erpClssId
 *	String ErpClassName;///<erpClassName
 *	long StoreNavType;///< 小租户搜索导航挂载方式 
 *****以上是版本146所包含的字段*******
 *
 *****以下是版本140所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long NavId;///< 导航id 
 *	long MapId;///<地图id
 *	long PNavId;///< 父导航id 
 *	String Name;///< 导航名称 
 *	long Type;///< 导航类型 
 *	long Catalog;///< 导航分类 
 *	String Note;///< 备注 
 *	long Order;///< 排序字段 
 *	String PropertyStr;///< 导航property 
 *	String SearchCond;///< 搜索条件 
 *	long HasAttr;///< 是否有属性 
 *	String CustomStr1;///< 导航预留自定义串1 
 *	String CustomStr2;///< 导航预留自定义串2 
 *	long CustomUint1;///< 导航预留自定义整形字段1 
 *	long CustomUint2;///< 导航预留自定义整形字段2 
 *	long IsPreDelete;///< 是否预删除，0为否，其余为是 
 *	long IsCooperatorFirst;///< 是否合作伙伴优先，0为否，其余为是 
 *	long IsLowPriceFirst;///< 是否低价优先，0为否，其余为是 
 *	long IsHighPriceFirst;///< 是否高价优先，0为否，其余为是 
 *****以上是版本140所包含的字段*******
 *
 *****以下是版本141所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long NavId;///< 导航id 
 *	long MapId;///<地图id
 *	long PNavId;///< 父导航id 
 *	String Name;///< 导航名称 
 *	long Type;///< 导航类型 
 *	long Catalog;///< 导航分类 
 *	String Note;///< 备注 
 *	long Order;///< 排序字段 
 *	String PropertyStr;///< 导航property 
 *	String SearchCond;///< 搜索条件 
 *	long HasAttr;///< 是否有属性 
 *	String CustomStr1;///< 导航预留自定义串1 
 *	String CustomStr2;///< 导航预留自定义串2 
 *	long CustomUint1;///< 导航预留自定义整形字段1 
 *	long CustomUint2;///< 导航预留自定义整形字段2 
 *	long IsPreDelete;///< 是否预删除，0为否，其余为是 
 *	long IsCooperatorFirst;///< 是否合作伙伴优先，0为否，其余为是 
 *	long IsLowPriceFirst;///< 是否低价优先，0为否，其余为是 
 *	long IsHighPriceFirst;///< 是否高价优先，0为否，其余为是 
 *	BitSet PropertyMask;///<标记位，具体定义参见CLASS_PROPERTY
 *****以上是版本141所包含的字段*******
 *
 *****以下是版本142所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long NavId;///< 导航id 
 *	long MapId;///<地图id
 *	long PNavId;///< 父导航id 
 *	String Name;///< 导航名称 
 *	long Type;///< 导航类型 
 *	long Catalog;///< 导航分类 
 *	String Note;///< 备注 
 *	long Order;///< 排序字段 
 *	String PropertyStr;///< 导航property 
 *	String SearchCond;///< 搜索条件 
 *	long HasAttr;///< 是否有属性 
 *	String CustomStr1;///< 导航预留自定义串1 
 *	String CustomStr2;///< 导航预留自定义串2 
 *	long CustomUint1;///< 导航预留自定义整形字段1 
 *	long CustomUint2;///< 导航预留自定义整形字段2 
 *	long IsPreDelete;///< 是否预删除，0为否，其余为是 
 *	long IsCooperatorFirst;///< 是否合作伙伴优先，0为否，其余为是 
 *	long IsLowPriceFirst;///< 是否低价优先，0为否，其余为是 
 *	long IsHighPriceFirst;///< 是否高价优先，0为否，其余为是 
 *	BitSet PropertyMask;///<标记位，具体定义参见CLASS_PROPERTY
 *	Map<uint32_t,String> ExtraData;///<额外数据，key是业务id，value是业务数据
 *****以上是版本142所包含的字段*******
 *
 *****以下是版本143所包含的字段*******
 *	short version;///< 版本号, version需要小写 
 *	long NavId;///< 导航id 
 *	long MapId;///<地图id
 *	long PNavId;///< 父导航id 
 *	String Name;///< 导航名称 
 *	long Type;///< 导航类型 
 *	long Catalog;///< 导航分类 
 *	String Note;///< 备注 
 *	long Order;///< 排序字段 
 *	String PropertyStr;///< 导航property 
 *	String SearchCond;///< 搜索条件 
 *	long HasAttr;///< 是否有属性 
 *	String CustomStr1;///< 导航预留自定义串1 
 *	String CustomStr2;///< 导航预留自定义串2 
 *	long CustomUint1;///< 导航预留自定义整形字段1 
 *	long CustomUint2;///< 导航预留自定义整形字段2 
 *	long IsPreDelete;///< 是否预删除，0为否，其余为是 
 *	long IsCooperatorFirst;///< 是否合作伙伴优先，0为否，其余为是 
 *	long IsLowPriceFirst;///< 是否低价优先，0为否，其余为是 
 *	long IsHighPriceFirst;///< 是否高价优先，0为否，其余为是 
 *	BitSet PropertyMask;///<标记位，具体定义参见CLASS_PROPERTY
 *	Map<uint32_t,String> ExtraData;///<额外数据，key是业务id，value是业务数据
 *	String Photo;///<图片url
 *	String Link;///<图片链接url
 *****以上是版本143所包含的字段*******
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
