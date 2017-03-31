package cz.hanakocz.rccosmetic.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelTrainOperatorCap extends ModelBiped
{
  //fields
    ModelRenderer CapBody;
    ModelRenderer CapFront;
    ModelRenderer CapTop;
  
  public ModelTrainOperatorCap(float f)
  {
	  super(f);
	  textureWidth = 64;
	  textureHeight = 64;
      
      CapBody = new ModelRenderer(this, 0, 32);
      CapBody.addBox(-5F, -8F, -5F, 10, 3, 10);
      CapBody.setRotationPoint(0F, 0F, 0F);
      CapBody.setTextureSize(64, 64);
      CapBody.mirror = true;
      setRotation(CapBody, 0F, 0F, 0F);
      CapFront = new ModelRenderer(this, 0, 46);
      CapFront.addBox(-5F, -6F, -8F, 10, 1, 3);
      CapFront.setRotationPoint(0F, 0F, 0F);
      CapFront.setTextureSize(64, 64);
      CapFront.mirror = true;
      setRotation(CapFront, 0F, 0F, 0F);
      CapTop = new ModelRenderer(this, 0, 51);
      CapTop.addBox(-4F, -9F, -4F, 8, 1, 8);
      CapTop.setRotationPoint(0F, 0F, 0F);
      CapTop.setTextureSize(64, 64);
      CapTop.mirror = true;
      setRotation(CapTop, 0F, 0F, 0F);
      this.bipedHead.addChild(CapBody);
      this.bipedHead.addChild(CapFront);
      this.bipedHead.addChild(CapTop);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}

