package cz.hanakocz.rccosmetic.models.carts;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCartWood extends ModelCartBase
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
    ModelRenderer rodFrontLeftFront;
    ModelRenderer rodFrontLeftRear;
    ModelRenderer rodRearLeftRear;
    ModelRenderer rodRearLeftFront;
    ModelRenderer rodFrontRightFront;
    ModelRenderer rodFrontRightRear;
    ModelRenderer rodRearRightFront;
    ModelRenderer rodRearRightRear;
    ModelRenderer log1;
    ModelRenderer log2;
    ModelRenderer log3;
    ModelRenderer log4;
    ModelRenderer log5;
    ModelRenderer log6;
    ModelRenderer log7;
    ModelRenderer log8;
    ModelRenderer log9;
  
  public ModelCartWood()
  {
	  textureWidth = 128;
	  textureHeight = 64;
    
      wheelRearRightRear = new ModelRenderer(this, 14, 0);
      wheelRearRightRear.addBox(5F, 5F, 9F, 1, 2, 3);
      wheelRearRightRear.setRotationPoint(0F, 0F, 0F);
      wheelRearRightRear.setTextureSize(128, 64);
      wheelRearRightRear.mirror = true;
      setRotation(wheelRearRightRear, 0F, 0F, 0F);
      wheelRearLeftRear = new ModelRenderer(this, 0, 0);
      wheelRearLeftRear.addBox(-6F, 5F, 9F, 1, 2, 3);
      wheelRearLeftRear.setRotationPoint(0F, 0F, 0F);
      wheelRearLeftRear.setTextureSize(128, 64);
      wheelRearLeftRear.mirror = true;
      setRotation(wheelRearLeftRear, 0F, 0F, 0F);
      wheelRearLeftFront = new ModelRenderer(this, 0, 6);
      wheelRearLeftFront.addBox(-6F, 5F, 5F, 1, 2, 3);
      wheelRearLeftFront.setRotationPoint(0F, 0F, 0F);
      wheelRearLeftFront.setTextureSize(128, 64);
      wheelRearLeftFront.mirror = true;
      setRotation(wheelRearLeftFront, 0F, 0F, 0F);
      wheelRearRightFront = new ModelRenderer(this, 14, 6);
      wheelRearRightFront.addBox(5F, 5F, 5F, 1, 2, 3);
      wheelRearRightFront.setRotationPoint(0F, 0F, 0F);
      wheelRearRightFront.setTextureSize(128, 64);
      wheelRearRightFront.mirror = true;
      setRotation(wheelRearRightFront, 0F, 0F, 0F);
      wheelRear = new ModelRenderer(this, 0, 25);
      wheelRear.addBox(-7F, 3F, 5F, 14, 2, 7);
      wheelRear.setRotationPoint(0F, 0F, 0F);
      wheelRear.setTextureSize(128, 64);
      wheelRear.mirror = true;
      setRotation(wheelRear, 0F, 0F, 0F);
      wheelFrontRightRear = new ModelRenderer(this, 14, 12);
      wheelFrontRightRear.addBox(5F, 5F, -8F, 1, 2, 3);
      wheelFrontRightRear.setRotationPoint(0F, 0F, 0F);
      wheelFrontRightRear.setTextureSize(128, 64);
      wheelFrontRightRear.mirror = true;
      setRotation(wheelFrontRightRear, 0F, 0F, 0F);
      wheelFrontLeftFront = new ModelRenderer(this, 0, 18);
      wheelFrontLeftFront.addBox(-6F, 5F, -12F, 1, 2, 3);
      wheelFrontLeftFront.setRotationPoint(0F, 0F, 0F);
      wheelFrontLeftFront.setTextureSize(128, 64);
      wheelFrontLeftFront.mirror = true;
      setRotation(wheelFrontLeftFront, 0F, 0F, 0F);
      wheelFront = new ModelRenderer(this, 42, 25);
      wheelFront.addBox(-7F, 3F, -12F, 14, 2, 7);
      wheelFront.setRotationPoint(0F, 0F, 0F);
      wheelFront.setTextureSize(128, 64);
      wheelFront.mirror = true;
      setRotation(wheelFront, 0F, 0F, 0F);
      wheelFrontLeftRear = new ModelRenderer(this, 0, 12);
      wheelFrontLeftRear.addBox(-6F, 5F, -8F, 1, 2, 3);
      wheelFrontLeftRear.setRotationPoint(0F, 0F, 0F);
      wheelFrontLeftRear.setTextureSize(128, 64);
      wheelFrontLeftRear.mirror = true;
      setRotation(wheelFrontLeftRear, 0F, 0F, 0F);
      wheelFrontRightFront = new ModelRenderer(this, 14, 18);
      wheelFrontRightFront.addBox(5F, 5F, -12F, 1, 2, 3);
      wheelFrontRightFront.setRotationPoint(0F, 0F, 0F);
      wheelFrontRightFront.setTextureSize(128, 64);
      wheelFrontRightFront.mirror = true;
      setRotation(wheelFrontRightFront, 0F, 0F, 0F);
      cartBottom = new ModelRenderer(this, 0, 0);
      cartBottom.addBox(-7F, 2F, -12F, 14, 1, 24);
      cartBottom.setRotationPoint(0F, 0F, 0F);
      cartBottom.setTextureSize(128, 64);
      cartBottom.mirror = true;
      setRotation(cartBottom, 0F, 0F, 0F);
      rodFrontLeftFront = new ModelRenderer(this, 54, 14);
      rodFrontLeftFront.addBox(-7F, 0F, -11F, 1, 8, 1);
      rodFrontLeftFront.setRotationPoint(0F, -6F, 0F);
      rodFrontLeftFront.setTextureSize(128, 64);
      rodFrontLeftFront.mirror = true;
      setRotation(rodFrontLeftFront, 0F, 0F, 0F);
      rodFrontLeftRear = new ModelRenderer(this, 59, 14);
      rodFrontLeftRear.addBox(-7F, -6F, -7F, 1, 8, 1);
      rodFrontLeftRear.setRotationPoint(0F, 0F, 0F);
      rodFrontLeftRear.setTextureSize(128, 64);
      rodFrontLeftRear.mirror = true;
      setRotation(rodFrontLeftRear, 0F, 0F, 0F);
      rodRearLeftRear = new ModelRenderer(this, 59, 0);
      rodRearLeftRear.addBox(-7F, -6F, 10F, 1, 8, 1);
      rodRearLeftRear.setRotationPoint(0F, 0F, 0F);
      rodRearLeftRear.setTextureSize(128, 64);
      rodRearLeftRear.mirror = true;
      setRotation(rodRearLeftRear, 0F, 0F, 0F);
      rodRearLeftFront = new ModelRenderer(this, 54, 0);
      rodRearLeftFront.addBox(-7F, -6F, 6F, 1, 8, 1);
      rodRearLeftFront.setRotationPoint(0F, 0F, 0F);
      rodRearLeftFront.setTextureSize(128, 64);
      rodRearLeftFront.mirror = true;
      setRotation(rodRearLeftFront, 0F, 0F, 0F);
      rodFrontRightFront = new ModelRenderer(this, 64, 14);
      rodFrontRightFront.addBox(6F, -6F, -11F, 1, 8, 1);
      rodFrontRightFront.setRotationPoint(0F, 0F, 0F);
      rodFrontRightFront.setTextureSize(128, 64);
      rodFrontRightFront.mirror = true;
      setRotation(rodFrontRightFront, 0F, 0F, 0F);
      rodFrontRightRear = new ModelRenderer(this, 69, 14);
      rodFrontRightRear.addBox(6F, -6F, -7F, 1, 8, 1);
      rodFrontRightRear.setRotationPoint(0F, 0F, 0F);
      rodFrontRightRear.setTextureSize(128, 64);
      rodFrontRightRear.mirror = true;
      setRotation(rodFrontRightRear, 0F, 0F, 0F);
      rodRearRightFront = new ModelRenderer(this, 64, 0);
      rodRearRightFront.addBox(6F, -6F, 6F, 1, 8, 1);
      rodRearRightFront.setRotationPoint(0F, 0F, 0F);
      rodRearRightFront.setTextureSize(128, 64);
      rodRearRightFront.mirror = true;
      setRotation(rodRearRightFront, 0F, 0F, 0F);
      rodRearRightRear = new ModelRenderer(this, 69, 0);
      rodRearRightRear.addBox(6F, -6F, 10F, 1, 8, 1);
      rodRearRightRear.setRotationPoint(0F, 0F, 0F);
      rodRearRightRear.setTextureSize(128, 64);
      rodRearRightRear.mirror = true;
      setRotation(rodRearRightRear, 0F, 0F, 0F);
      log1 = new ModelRenderer(this, 0, 34);
	  log1.addBox(-6F, -1F, -12F, 3, 3, 24);
	  log1.setRotationPoint(0F, 0F, 0F);
	  log1.setTextureSize(128, 64);
	  log1.mirror = true;
	  setRotation(log1, 0F, 0F, 0F);   	  
	  log2 = new ModelRenderer(this, 0, 34);
      log2.addBox(-3F, -1F, -12F, 3, 3, 24);
      log2.setRotationPoint(0F, 0F, 0F);
      log2.setTextureSize(128, 64);
      log2.mirror = true;
      setRotation(log2, 0F, 0F, 0F);   	  
	  log3 = new ModelRenderer(this, 0, 34);
      log3.addBox(0F, -1F, -12F, 3, 3, 24);
      log3.setRotationPoint(0F, 0F, 0F);
      log3.setTextureSize(128, 64);
      log3.mirror = true;
      setRotation(log3, 0F, 0F, 0F);
	  log4 = new ModelRenderer(this, 0, 34);
      log4.addBox(3F, -1F, -12F, 3, 3, 24);
      log4.setRotationPoint(0F, 0F, 0F);
      log4.setTextureSize(128, 64);
      log4.mirror = true;
      setRotation(log4, 0F, 0F, 0F);
      log5 = new ModelRenderer(this, 0, 34);
      log5.addBox(-5F, -4F, -12F, 3, 3, 24);
      log5.setRotationPoint(0F, 0F, 0F);
      log5.setTextureSize(128, 64);
      log5.mirror = true;
      setRotation(log5, 0F, 0F, 0F);
      log6 = new ModelRenderer(this, 0, 34);
      log6.addBox(-2F, -4F, -12F, 3, 3, 24);
      log6.setRotationPoint(0F, 0F, 0F);
      log6.setTextureSize(128, 64);
      log6.mirror = true;
      setRotation(log6, 0F, 0F, 0F);
      log7 = new ModelRenderer(this, 0, 34);
      log7.addBox(1F, -4F, -12F, 3, 3, 24);
      log7.setRotationPoint(0F, 0F, 0F);
      log7.setTextureSize(128, 64);
      log7.mirror = true;
      setRotation(log7, 0F, 0F, 0F); 
	  log8 = new ModelRenderer(this, 0, 34);
      log8.addBox(-3F, -7F, -12F, 3, 3, 24);
      log8.setRotationPoint(0F, 0F, 0F);
      log8.setTextureSize(128, 64);
      log8.mirror = true;
      setRotation(log8, 0F, 0F, 0F);
	  log9 = new ModelRenderer(this, 0, 34);
      log9.addBox(0F, -7F, -12F, 3, 3, 24);
      log9.setRotationPoint(0F, 0F, 0F);
      log9.setTextureSize(128, 64);
      log9.mirror = true;
      setRotation(log9, 0F, 0F, 0F);
  
      
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
    rodFrontLeftFront.render(f5);
    rodFrontLeftRear.render(f5);
    rodRearLeftRear.render(f5);
    rodRearLeftFront.render(f5);
    rodFrontRightFront.render(f5);
    rodFrontRightRear.render(f5);
    rodRearRightFront.render(f5);
    rodRearRightRear.render(f5);
    if (items > 0) log1.render(f5);
    if (items > 1) log2.render(f5);
    if (items > 2) log3.render(f5);
    if (items > 3) log4.render(f5);
    if (items > 4) log5.render(f5);
    if (items > 5) log6.render(f5);
    if (items > 6) log7.render(f5);
    if (items > 7) log8.render(f5);
    if (items > 8) log9.render(f5);
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
