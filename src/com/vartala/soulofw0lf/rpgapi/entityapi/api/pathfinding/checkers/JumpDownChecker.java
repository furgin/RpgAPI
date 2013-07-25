package com.vartala.soulofw0lf.rpgapi.entityapi.api.pathfinding.checkers;

import org.bukkit.block.BlockFace;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.pathfinding.MoveData;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.pathfinding.Pathfinder;

public class JumpDownChecker implements MoveChecker
{
	@Override
	public void checkMove(MoveData inData)
	{
		if(!inData.isValid())
			return;

		if(inData.getYDiff() == -1)
		{
			if((!Pathfinder.isTransparent(inData.getAboveBlock()) && !Pathfinder.isLiquid(inData.getAboveBlock())) || (!Pathfinder.isTransparent(inData.getHeadBlock()) && !Pathfinder.isLiquid(inData.getHeadBlock())) || (!Pathfinder.isTransparent(inData.getHeadBlock().getRelative(BlockFace.UP))  && !Pathfinder.isLiquid(inData.getHeadBlock().getRelative(BlockFace.UP))))
				inData.setValid(false);
		}
	}
}