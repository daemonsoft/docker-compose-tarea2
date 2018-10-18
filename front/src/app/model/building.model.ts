 interface Building {
	buildingId: string;
	buildingName: string;
	tenantId: string;
	tenantName: string;
	tenantAge: number;
}

class BuildingClass implements Building {
	buildingId: string;
	buildingName: string;
	tenantId: string;
	tenantName: string;
	tenantAge: number;

	constructor(buildingId: string, buildingName: string, tenantId: string, tenantName: string, tenantAge: number) {
		this.buildingId = buildingId;
		this.buildingName = buildingName;
		this.tenantId = tenantId;
		this.tenantName = tenantName;
		this.tenantAge = tenantAge;
	}
}

export { Building, BuildingClass }