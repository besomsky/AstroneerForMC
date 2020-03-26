// Made with Blockbench
// Paste this code into your mod.
// Make sure to generate all required imports

public static class ModelPortal extends ModelBase {
	private final ModelRenderer bone;
	private final ModelRenderer bone2;

	public ModelPortal() {
		textureWidth = 64;
		textureHeight = 64;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -1.0F, -6.0F, 3, 1, 11, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 0, -2.0F, -8.0F, 5.0F, 3, 7, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 17, 0, -2.0F, -13.0F, 6.0F, 3, 5, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 34, 18, -2.0F, -24.0F, 7.0F, 3, 11, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 22, 18, -2.0F, -4.0F, -7.0F, 3, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 8, 37, -2.0F, -25.0F, 3.0F, 3, 1, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 36, 12, -2.0F, -24.0F, -1.0F, 3, 1, 4, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 17, 6, -2.0F, -23.0F, -3.0F, 3, 1, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 18, 12, -2.0F, -22.0F, -4.0F, 3, 3, 1, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 8, -2.0F, -19.0F, -6.0F, 3, 1, 2, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 26, 26, -2.0F, -18.0F, -7.0F, 3, 14, 1, 0.0F, false));

		bone2 = new ModelRenderer(this);
		bone2.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone2.cubeList.add(new ModelBox(bone2, 0, 12, -1.0F, -23.0F, 0.0F, 1, 22, 5, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 26, 22, -1.0F, -24.0F, 3.0F, 1, 1, 2, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 18, 18, -1.0F, -23.0F, -1.0F, 1, 22, 1, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 12, 12, -1.0F, -22.0F, -3.0F, 1, 21, 2, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 22, 22, -1.0F, -19.0F, -4.0F, 1, 18, 1, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 28, 0, -1.0F, -18.0F, -5.0F, 1, 17, 1, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 32, 0, -1.0F, -18.0F, -6.0F, 1, 17, 1, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 38, 38, -1.0F, -24.0F, 6.0F, 1, 11, 1, 0.0F, false));
		bone2.cubeList.add(new ModelBox(bone2, 34, 34, -1.0F, -24.0F, 5.0F, 1, 16, 1, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		bone.render(f5);
		bone2.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}