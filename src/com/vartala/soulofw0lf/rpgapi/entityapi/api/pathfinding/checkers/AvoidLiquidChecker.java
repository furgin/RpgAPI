package com.vartala.soulofw0lf.rpgapi.entityapi.api.pathfinding.checkers;

import com.vartala.soulofw0lf.rpgapi.entityapi.api.pathfinding.MoveData;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.pathfinding.Pathfinder;

public class AvoidLiquidChecker implements MoveChecker
{
	@Override
	public void checkMove(MoveData inData)
	{
		if(!inData.isValid())
			return;

		if(Pathfinder.isLiquid(inData.getBlock()) || Pathfinder.isLiquid(inData.getAboveBlock()))
			inData.setValid(false);
	}
}