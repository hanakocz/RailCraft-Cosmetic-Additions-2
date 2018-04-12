package cz.hanakocz.rccosmetic.models.carts;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCartCouch extends ModelCartBase
{
	  //fields
    ModelRenderer wheelRearRightRear;
    ModelRenderer wheelRearLeftRear;
    ModelRenderer wheelRearLeftFront;
    ModelRenderer wheelRearRightFront;
    ModelRenderer wheelRear;
    ModelRenderer wheelFrontRightRear;
    ModelRenderer wheelFrontLeftFront;
    ModelRenderer wheelFront;
    ModelRenderer wheelFrontLeftRear;
    ModelRenderer wheelFrontRightFront;
    ModelRenderer cartBottom;
    ModelRenderer bodyMain;
    ModelRenderer bodyTop;
  
  public ModelCartCouch()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      wheelRearRightRear = new ModelRenderer(this, 14, 0);
      wheelRearRightRear.addBox(5F, 5F, 9F, 1, 2, 3);
      wheelRearRightRear.setRotationPoint(0F, 0F, 0F);
      wheelRearRightRear.setTextureSize(128, 128);
      wheelRearRightRear.mirror = true;
      setRotation(wheelRearRightRear, 0F, 0F, 0F);
      wheelRearLeftRear = new ModelRenderer(this, 0, 0);
      wheelRearLeftRear.addBox(-6F, 5F, 9F, 1, 2, 3);
      wheelRearLeftRear.setRotationPoint(0F, 0F, 0F);
      wheelRearLeftRear.setTextureSize(128, 128);
      wheelRearLeftRear.mirror = true;
      setRotation(wheelRearLeftRear, 0F, 0F, 0F);
      wheelRearLeftFront = new ModelRenderer(this, 0, 6);
      wheelRearLeftFront.addBox(-6F, 5F, 5F, 1, 2, 3);
      wheelRearLeftFront.setRotationPoint(0F, 0F, 0F);
      wheelRearLeftFront.setTextureSize(128, 128);
      wheelRearLeftFront.mirror = true;
      setRotation(wheelRearLeftFront, 0F, 0F, 0F);
      wheelRearRightFront = new ModelRenderer(this, 14, 6);
      wheelRearRightFront.addBox(5F, 5F, 5F, 1, 2, 3);
      wheelRearRightFront.setRotationPoint(0F, 0F, 0F);
      wheelRearRightFront.setTextureSize(128, 128);
      wheelRearRightFront.mirror = true;
      setRotation(wheelRearRightFront, 0F, 0F, 0F);
      wheelRear = new ModelRenderer(this, 0, 25);
      wheelRear.addBox(-7F, 3F, 5F, 14, 2, 7);
      wheelRear.setRotationPoint(0F, 0F, 0F);
      wheelRear.setTextureSize(128, 128);
      wheelRear.mirror = true;
      setRotation(wheelRear, 0F, 0F, 0F);
      wheelFrontRightRear = new ModelRenderer(this, 14, 12);
      wheelFrontRightRear.addBox(5F, 5F, -8F, 1, 2, 3);
      wheelFrontRightRear.setRotationPoint(0F, 0F, 0F);
      wheelFrontRightRear.setTextureSize(128, 128);
      wheelFrontRightRear.mirror = true;
      setRotation(wheelFrontRightRear, 0F, 0F, 0F);
      wheelFrontLeftFront = new ModelRenderer(this, 0, 18);
      wheelFrontLeftFront.addBox(-6F, 5F, -12F, 1, 2, 3);
      wheelFrontLeftFront.setRotationPoint(0F, 0F, 0F);
      wheelFrontLeftFront.setTextureSize(128, 128);
      wheelFrontLeftFront.mirror = true;
      setRotation(wheelFrontLeftFront, 0F, 0F, 0F);
      wheelFront = new ModelRenderer(this, 42, 25);
      wheelFront.addBox(-7F, 3F, -12F, 14, 2, 7);
      wheelFront.setRotationPoint(0F, 0F, 0F);
      wheelFront.setTextureSize(128, 128);
      wheelFront.mirror = true;
      setRotation(wheelFront, 0F, 0F, 0F);
      wheelFrontLeftRear = new ModelRenderer(this, 0, 12);
      wheelFrontLeftRear.addBox(-6F, 5F, -8F, 1, 2, 3);
      wheelFrontLeftRear.setRotationPoint(0F, 0F, 0F);
      wheelFrontLeftRear.setTextureSize(128, 128);
      wheelFrontLeftRear.mirror = true;
      setRotation(wheelFrontLeftRear, 0F, 0F, 0F);
      wheelFrontRightFront = new ModelRenderer(this, 14, 18);
      wheelFrontRightFront.addBox(5F, 5F, -12F, 1, 2, 3);
      wheelFrontRightFront.setRotationPoint(0F, 0F, 0F);
      wheelFrontRightFront.setTextureSize(128, 128);
      wheelFrontRightFront.mirror = true;
      setRotation(wheelFrontRightFront, 0F, 0F, 0F);
      cartBottom = new ModelRenderer(this, 0, 0);
      cartBottom.addBox(-7F, 2F, -12F, 14, 1, 24);
      cartBottom.setRotationPoint(0F, 0F, 0F);
      cartBottom.setTextureSize(128, 128);
      cartBottom.mirror = true;
      setRotation(cartBottom, 0F, 0F, 0F);
      bodyMain = new ModelRenderer(this, 0, 35);
      bodyMain.addBox(-7F, -7F, -12F, 14, 9, 24);
      bodyMain.setRotationPoint(0F, 0F, 0F);
      bodyMain.setTextureSize(128, 128);
      bodyMain.mirror = true;
      setRotation(bodyMain, 0F, 0F, 0F);
      bodyTop = new ModelRenderer(this, 0, 69);
      bodyTop.addBox(-5F, -9F, -12F, 10, 2, 24);
      bodyTop.setRotationPoint(0F, 0F, 0F);
      bodyTop.setTextureSize(128, 128);
      bodyTop.mirror = true;
      setRotation(bodyTop, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, int items)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    GL11.glRotatef(90, 0, 1, 0);
    wheelRearRightRear.render(f5);
    wheelRearLeftRear.render(f5);
    wheelRearLeftFront.render(f5);
    wheelRearRightFront.render(f5);
    wheelRear.render(f5);
    wheelFrontRightRear.render(f5);
    wheelFrontLeftFront.render(f5);
    wheelFront.render(f5);
    wheelFrontLeftRear.render(f5);
    wheelFrontRightFront.render(f5);
    cartBottom.render(f5);
    bodyMain.render(f5);
    bodyTop.render(f5);
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
