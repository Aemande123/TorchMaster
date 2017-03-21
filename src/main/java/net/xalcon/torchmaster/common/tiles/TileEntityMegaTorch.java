package net.xalcon.torchmaster.common.tiles;

import net.minecraft.tileentity.TileEntity;
import net.xalcon.torchmaster.server.TorchRegistry;

public class TileEntityMegaTorch extends TileEntity
{
	@Override
	public void onLoad()
	{
		super.onLoad();
		if(!this.worldObj.isRemote)
			TorchRegistry.getMegaTorchRegistry().registerTorch(this.getWorld(), this.getPos());
	}

	@Override
	public void invalidate()
	{
		super.invalidate();
		if(!worldObj.isRemote)
			TorchRegistry.getMegaTorchRegistry().unregisterTorch(this.getWorld(), this.getPos());
	}

	@Override
	public void onChunkUnload()
	{
		super.onChunkUnload();
		if(!worldObj.isRemote)
			TorchRegistry.getMegaTorchRegistry().unregisterTorch(this.getWorld(), this.getPos());
	}
}
