package com.vartala.soulofw0lf.rpgapi.entityapi.persistence.serializers;

import java.io.*;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.craftbukkit.libs.com.google.gson.Gson;
import org.bukkit.craftbukkit.libs.com.google.gson.GsonBuilder;
import org.bukkit.plugin.Plugin;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.EntityData;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.ParameterData;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.ParameterDataDeserializer;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.ParameterDataSerializer;

/**
 * This represents a serializer which outputs the serialized data into a json format/file.
 */
public class JSONSerializer extends PreparationSerializer
{
	protected Class<? extends EntityData[]> m_dataClass;
	protected Gson m_gson;

	public JSONSerializer(Plugin inPlugin)
	{
		this(inPlugin, EntityData[].class);
	}

	public JSONSerializer(Plugin inPlugin, Class<? extends EntityData[]> inDataClass)
	{
		super(inPlugin);
		this.m_dataClass = inDataClass;
		this.m_gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(ParameterData.class, new ParameterDataSerializer()).registerTypeAdapter(ParameterData.class, new ParameterDataDeserializer()).create();
	}

	@Override
	public boolean save(EntityData[] inData)
	{
		String json = this.m_gson.toJson(inData);
		return this.writeToFile(json);
	}

	@Override
	public EntityData[] loadData()
	{
		File jsonFile = new File(RpgAPI.getInstance().getDataFolder(), this.m_plugin.getName() + File.separator + "entities.json");
		if(!jsonFile.exists())
			return new EntityData[0];

		try
		{
			return this.m_gson.fromJson(new FileReader(jsonFile), this.m_dataClass);
		}
		catch(Exception e)
		{
			return new EntityData[0];
		}
	}

	protected boolean writeToFile(String inJson)
	{
		try
		{
			File fileFolder = new File(RpgAPI.getInstance().getDataFolder(), this.m_plugin.getName());
			if(!fileFolder.exists())
			{
				if(!fileFolder.mkdirs())
					return false;
			}

			File jsonFile = new File(fileFolder, "entities.json");
			if(!jsonFile.exists())
			{
				if(!jsonFile.createNewFile())
					return false;
			}

			FileWriter writer = new FileWriter(jsonFile);
			writer.write(inJson);
			writer.close();
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
}