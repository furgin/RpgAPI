package com.vartala.soulofw0lf.rpgapi.entityapi.api.pathfinding.checkers;

import com.vartala.soulofw0lf.rpgapi.entityapi.api.pathfinding.MoveData;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.pathfinding.Pathfinder;

public class AirChecker implements MoveChecker
{
	@Override
	public void checkMove(MoveData inData)
	{
		if(inData.getYDiff() >= 0)
		{
			if(!Pathfinder.isTransparent(inData.getBlock()) && !Pathfinder.isLiquid(inData.getBlock()))
				inData.setValid(false);
		}
	}
}