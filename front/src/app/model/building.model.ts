 interface Building {
	buildingId: number;
	buildingName: string;
	tenantId: number;
	tenantName: string;
	tenantAge: number;
}

class BuildingClass implements Building {
	buildingId: number;
	buildingName: string;
	tenantId: number;
	tenantName: string;
	tenantAge: number;

	constructor(buildingId: number, buildingName: string, tenantId: number, tenantName: string, tenantAge: number) {
		this.buildingId = buildingId;
		this.buildingName = buildingName;
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.tenantAge = tenantAge;
	}
}

export { Building, BuildingClass }