package com.vartala.soulofw0lf.rpgapi.entityapi.persistence.serializers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.Plugin;
import com.vartala.soulofw0lf.rpgapi.entityapi.RemoteEntities;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.EntityData;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.ISingleEntitySerializer;

/**
 * This represents a serializer which outputs the serialized data to a yml string/file.
 */
public class YMLSerializer extends PreparationSerializer implements ISingleEntitySerializer
{
	protected FileConfiguration m_config;
	protected File m_configFile;

	public YMLSerializer(Plugin inPlugin)
	{
		super(inPlugin);
		ConfigurationSerialization.registerClass(EntityData.class);
	}

	@Override
	public boolean save(EntityData[] inData)
	{
		try
		{
			if(this.m_config == null || this.m_configFile == null)
			{
				if(!this.loadConfig())
					return false;
			}

			this.m_config.set("entities", inData);
			this.m_config.save(this.m_configFile);

			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public EntityData[] loadData()
	{
		if(this.m_configFile == null || this.m_config == null)
		{
			if(!this.loadConfig())
				return new EntityData[0];
		}

		if(!this.m_config.contains("entities"))
			return new EntityData[0];

		List<EntityData> entitydata = (List<EntityData>)this.m_config.getList("entities");
		return entitydata.toArray(new EntityData[entitydata.size()]);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void save(EntityData inData)
	{
		try
		{
			if(this.m_config == null || this.m_configFile == null)
			{
				if(!this.loadConfig())
					return;
			}
             if (this.m_config.get("entities") == null){
                 List<EntityData> eD = new ArrayList<>();
                 eD.add(inData);
                 this.m_config.set("entities", eD);
                 this.m_config.save(this.m_configFile);

             } else {
                 List<EntityData> eD = (List<EntityData>)this.m_config.getList("entities");
                 eD.add(inData);
                 this.m_config.set("entities", eD);
                 this.m_config.save(this.m_configFile);
             }

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public EntityData load(Object inParameter)
	{
		EntityData[] data = this.loadData();
		for(EntityData entity : data)
		{
			if(inParameter instanceof String)
			{
				if(inParameter.equals(entity.name))
					return entity;
			}
			else if(inParameter instanceof Integer)
			{
				if(inParameter.equals(entity.id))
					return entity;
			}
		}
		return null;
	}

	protected boolean loadConfig()
	{
		try
		{
			File fileFolder = new File("plugins/RpgMinions");
			if(!fileFolder.exists())
			{
				if(!fileFolder.mkdirs())
					return false;
			}

			this.m_configFile = new File("plugins/RpgMinions/entities.yml");
			if(!this.m_configFile.exists())
			{
				if(!this.m_configFile.createNewFile())
					return false;
			}

			this.m_config = YamlConfiguration.loadConfiguration(this.m_configFile);
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}